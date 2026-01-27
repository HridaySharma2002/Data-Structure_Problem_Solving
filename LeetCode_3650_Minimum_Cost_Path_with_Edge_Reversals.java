class Solution {
    public int minCost(int n, int[][] edges) {
        // Create an adjacency list to represent the graph
        // Each element in the list is a list of int arrays [neighbor, weight]
        List<List<int[]>> graph = new ArrayList<>();
        
        // Initialize the adjacency list with empty lists for each node
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph from the edges input
        // For each edge, add the neighbor and weight to both nodes' adjacency lists
        // Note: The weight from u to v is w, but from v to u is 2*w (asymmetric)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, 2 * w});
        }
        
        // Run Dijkstra's algorithm on the constructed graph to find min cost path
        return dijkstra(n, graph);
    }

    // Helper method implementing Dijkstra's algorithm to find shortest path cost
    private int dijkstra(int n, List<List<int[]>> graph) {
        int INF = (int) 1e9;  // A large number representing infinity
        
        int[] dist = new int[n];      // dist[i] will hold the shortest distance from node 0 to i
        boolean[] vis = new boolean[n]; // vis[i] marks if node i has been processed
        
        // Initialize all distances to infinity except the start node (0)
        Arrays.fill(dist, INF);
        dist[0] = 0;
        
        // Priority queue to pick the next node with the smallest tentative distance
        // Each element is an int array: [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});  // Start with node 0 and distance 0
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];  // Current node
            
            // If this node was already visited, skip it
            if (vis[u]) {
                continue;
            }
            vis[u] = true;  // Mark node as visited
            
            // Explore all neighbors of u
            for (int[] e : graph.get(u)) {
                int v = e[0];  // Neighbor node
                int w = e[1];  // Edge weight
                
                // If a shorter path to v is found through u, update dist[v]
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});  // Add updated distance and node to the queue
                }
            }
        }
        
        // If the distance to the last node is still INF, no path exists, return -1
        // Otherwise, return the shortest distance found
        return dist[n - 1] == INF ? -1 : dist[n - 1];
    }
}
