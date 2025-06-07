class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        // Initialize the index for tracking the current query being processed
        int queryIndex = 0;

        // PriorityQueue to store the right indices of available queries in descending order
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());

        // PriorityQueue to store the currently active right indices of queries being processed
        PriorityQueue<Integer> running = new PriorityQueue<>();

        // Sort the queries based on their left index (the first element of each query)
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        // Iterate through each element in the nums array
        for (int i = 0; i < nums.length; i++) {
            // Add all queries that start at or before the current index i to the available queue
            while (queryIndex < queries.length && queries[queryIndex][0] <= i) {
                // Offer the right index of the current query to the available queue
                available.offer(queries[queryIndex++][1]);
            }

            // Remove any queries from the running queue that have ended before the current index i
            while (!running.isEmpty() && running.peek() < i) {
                running.poll(); // Remove the expired query
            }

            // Ensure we can decrement nums[i] to zero using the available queries
            while (nums[i] > running.size()) {
                // If there are no available queries or the next available query cannot be used
                if (available.isEmpty() || available.peek() < i) {
                    return -1; // It's not possible to make nums zero
                }
                // Use the next available query by moving it to the running queue
                running.offer(available.poll());
            }
        }

        // Return the number of queries that can be removed while still allowing nums to be zeroed
        return available.size();
    }
}
