class Solution {
    // Helper class to store the number of stops, current node, and current cost
    class Tuple {
        int first;  // Number of stops made
        int second; // Current node (city)
        int third;  // Current cost to reach this node
        
        // Constructor to initialize the Tuple object
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    // Helper class to store the adjacent node and the cost to reach it
    class Pair {
        int first;  // Adjacent node (city)
        int second; // Cost to reach the adjacent node
        
        // Constructor to initialize the Pair object
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // Initialize each list for the cities
        }

        // Populate the adjacency list with flight information
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); // Add destination and cost
        }

        // Distance array to track the minimum cost to reach each city
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9); // Initialize distances to a large number (infinity)
        }

        dist[src] = 0; // Starting point has zero cost

        // Queue for BFS, storing {stops, current city, current cost}
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0)); // Start from the source city with 0 stops and 0 cost

        // Perform BFS to find the cheapest price
        while (!queue.isEmpty()) {
            Tuple current = queue.poll(); // Get the current state from the queue
            int stops = current.first; // Number of stops made
            int node = current.second; // Current city
            int cost = current.third; // Current cost to reach this city

            // If the number of stops exceeds k, skip this path
            if (stops > k) {
                continue;
            }

            // Explore all adjacent cities
            for (Pair adjacent : adj.get(node)) {
                int adjNode = adjacent.first; // Adjacent city
                int edgeWeight = adjacent.second; // Cost to reach the adjacent city
                
                // If the new cost is less than the previously recorded cost
                if (cost + edgeWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edgeWeight; // Update the minimum cost to reach the adjacent city
                    queue.add(new Tuple(stops + 1, adjNode, cost + edgeWeight)); // Add the new state to the queue
                }
            }
        }

        // If the destination city is unreachable, return -1
        if (dist[dst] == (int)(1e9)) {
            return -1; // Destination is unreachable
        }

        // Return the minimum cost to reach the destination city
        return dist[dst];
    }
}
