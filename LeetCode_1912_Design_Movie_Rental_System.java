// MovieRentingSystem manages renting and reporting of movies across multiple shops.
class MovieRentingSystem {
    // Node represents a unique (shop, movie, price) tuple.
    private static class Node {
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Comparator for ordering Nodes: by price (asc), then shop (asc), then movie (asc).
    // Ensures strict ordering (no two distinct nodes compare as equal).
    private static final Comparator<Node> CMP =
        (a, b) -> {
            int c = Integer.compare(a.price, b.price);
            if (c != 0) return c;
            c = Integer.compare(a.shop, b.shop);
            if (c != 0) return c;
            return Integer.compare(a.movie, b.movie);
        };

    // Maps each movie to a TreeSet of available Nodes (copies), ordered by CMP.
    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
    // TreeSet of all currently rented Nodes, ordered by CMP.
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
    // Maps (shop, movie) pair (as a long key) to its Node for quick lookup.
    private final Map<Long, Node> byPair = new HashMap<>();

    // Helper to generate a unique long key from (shop, movie) pair.
    private static long key(int shop, int movie) {
        return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    // Constructor: initializes the system with all available entries.
    // Each entry is [shop, movie, price].
    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node); // Store for quick lookup.
            // Add node to the set of available copies for this movie.
            availableByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(CMP))
                .add(node);
        }
    }

    // Returns up to 5 shops with the given movie available, sorted by price then shop.
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set == null || set.isEmpty()) return ans; // No available copies.
        Iterator<Node> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            ans.add(it.next().shop);
        }
        return ans;
    }

    // Rents a movie from a shop: moves the Node from available to rented.
    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // Defensive: node must exist.
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set != null) set.remove(node); // Remove from available.
        rentedSet.add(node); // Add to rented.
    }

    // Drops a rented movie: moves the Node from rented back to available.
    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // Defensive: node must exist.
        rentedSet.remove(node); // Remove from rented.
        // Add back to available for this movie.
        availableByMovie
            .computeIfAbsent(movie, x -> new TreeSet<>(CMP))
            .add(node);
    }

    // Returns up to 5 rented movies as [shop, movie] pairs, sorted by price, shop, movie.
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}

/**
 * Usage:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop, movie);
 * obj.drop(shop, movie);
 * List<List<Integer>> param_4 = obj.report();
 */
