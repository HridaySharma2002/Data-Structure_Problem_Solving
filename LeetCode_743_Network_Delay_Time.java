// Class to represent a pair of values: a node and its associated time
class Pair {
    int first;  // Represents the node
    int second; // Represents the time to reach that node

    // Constructor to initialize the Pair with node and time
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list to represent the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and their weights
        for (int time[] : times) {
            adj.get(time[0] - 1).add(new Pair(time[1] - 1, time[2]));
        }

        // Priority queue to process nodes based on the minimum time
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));

        // Array to track the minimum time to reach each node
        int[] visitedtime = new int[n];
        for (int i = 0; i < n; i++) {
            visitedtime[i] = Integer.MAX_VALUE; // Initialize with infinity
        }

        // Start from the given node k
        visitedtime[k - 1] = 0; // Time to reach the starting node is 0
        pq.offer(new Pair(k - 1, 0)); // Add the starting node to the priority queue

        // Process the nodes in the priority queue
        while (!pq.isEmpty()) {
            Pair it = pq.poll(); // Get the node with the smallest time
            int node = it.first; // Current node
            int time = it.second; // Time to reach the current node

            // Explore all adjacent nodes
            for (Pair adjacent : adj.get(node)) {
                int adjnode = adjacent.first; // Neighbor node
                int edgwt = adjacent.second; // Edge weight (time to neighbor)

                // If a shorter path to the neighbor is found
                if (time + edgwt < visitedtime[adjnode]) {
                    visitedtime[adjnode] = time + edgwt; // Update the time
                    pq.offer(new Pair(adjnode, visitedtime[adjnode])); // Add to the queue
                }
            }
        }

        // Determine the maximum time taken to reach any node
        int maxtime = 0;
        for (int time : visitedtime) {
            if (time == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable, return -1
            }
            maxtime = Math.max(maxtime, time); // Update the maximum time
        }

        return maxtime; // Return the maximum time taken to reach all nodes
    }
}
