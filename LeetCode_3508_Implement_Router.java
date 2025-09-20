class Router {
    // Maximum number of packets the router can hold at any time.
    private final int size;

    // Maps destination to a list of timestamps for packets sent to that destination.
    private final Map<Integer, List<Integer>> counts;

    // Maps a unique key (source, destination, timestamp) to the packet data.
    private final Map<Long, int[]> packets;

    // Queue to maintain the order of packet arrival for FIFO forwarding.
    private final Queue<Long> queue;

    /**
     * Constructor initializes the router with a memory limit.
     * @param memoryLimit Maximum number of packets the router can store.
     */
    public Router(final int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    /**
     * Adds a packet to the router.
     * If the packet already exists, returns false.
     * If memory is full, forwards the oldest packet before adding.
     * @param source Source address of the packet.
     * @param destination Destination address of the packet.
     * @param timestamp Timestamp of the packet.
     * @return true if the packet was added, false if it was a duplicate.
     */
    public boolean addPacket(final int source, final int destination, final int timestamp) {
        final long key = encode(source, destination, timestamp);

        // If packet already exists, do not add.
        if(packets.containsKey(key))
            return false;

        // If memory is full, forward the oldest packet.
        if(packets.size() >= size)
            forwardPacket();

        // Add the new packet.
        packets.put(key, new int[] { source, destination, timestamp });
        queue.offer(key);

        // Track the timestamp for the destination.
        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);

        return true;
    }

    /**
     * Forwards (removes) the oldest packet from the router.
     * Updates the counts for the destination.
     * @return The forwarded packet as an int array, or empty array if none.
     */
    public int[] forwardPacket() {
        if(packets.isEmpty())
            return new int[] {};

        // Remove the oldest packet from the queue and map.
        final long key = queue.poll();
        final int[] packet = packets.remove(key);

        if(packet == null)
            return new int[]{};

        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);

        // Remove the earliest timestamp for this destination.
        list.remove(0);

        return packet;
    }

    /**
     * Returns the number of packets sent to a destination within [startTime, endTime].
     * @param destination The destination address.
     * @param startTime Start of the time range (inclusive).
     * @param endTime End of the time range (inclusive).
     * @return Number of packets in the given time range.
     */
    public int getCount(final int destination, final int startTime, final int endTime) {
        final List<Integer> list = counts.get(destination);
        if(list == null || list.isEmpty())
            return 0;

        // Use binary search to find the range of timestamps.
        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    /**
     * Encodes source, destination, and timestamp into a unique long key.
     */
    private long encode(final int source, final int destination, final int timestamp) {
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }

    /**
     * Finds the first index in the list where value >= target (lower bound).
     */
    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;
            if(list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    /**
     * Finds the first index in the list where value > target (upper bound).
     */
    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while(low < high) {
            final int mid = (low + high) >>> 1;

            if(list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
