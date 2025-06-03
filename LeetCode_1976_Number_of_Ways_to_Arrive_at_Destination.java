class Solution {
    // Inner class to represent a pair of integers
    class Pair {
        int node; // Represents the node index
        long time; // Represents the time to reach this node

        // Constructor to initialize the pair
        Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    // Method to count the number of paths from node 0 to node n-1
    public int countPaths(int n, int[][] roads) {
        // Create an adjacency list to represent the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with roads
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        // Priority queue to process nodes based on the shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.time));
        pq.offer(new Pair(0, 0)); // Start from node 0 with distance 0

        // Arrays to store the shortest distance and number of ways to reach each node
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); // Initialize distances to a large value
        dist[0] = 0; // Distance to the starting node is 0
        ways[0] = 1; // There is one way to reach the starting node

        int mod = (int) (1e9 + 7); // Modulo value to prevent overflow

        // Process the priority queue until it's empty
        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the node with the smallest distance
            int node = current.node; // Current node index
            long currentTime = current.time; // Current distance

            // Explore all adjacent nodes
            for (Pair adjacent : adj.get(node)) {
                int adjNode = adjacent.node; // Adjacent node index
                long edgeWeight = adjacent.time; // Weight of the edge

                // If a shorter path to adjNode is found
                if (currentTime + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currentTime + edgeWeight; // Update distance
                    ways[adjNode] = ways[node]; // Update ways to reach adjNode
                    pq.offer(new Pair(adjNode, dist[adjNode])); // Add to queue
                } 
                // If another path with the same distance is found
                else if (currentTime + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod; // Update ways
                }
            }
        }

        // Return the number of ways to reach the last node, modulo mod
        return (int) (ways[n - 1] % mod);
    }
}
