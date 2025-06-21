class Solution {
    int timer = 1; // Timer to keep track of discovery times of nodes

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from the connections
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Arrays to track visited nodes, discovery times, and low values
        int[] vis = new int[n]; // Visited array
        int[] tin = new int[n]; // Discovery times
        int low[] = new int[n]; // Lowest discovery time reachable
        List<List<Integer>> bridges = new ArrayList<>(); // List to store critical connections

        // Start DFS from node 0 with no parent
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges; // Return the list of critical connections
    }

    public void dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj, int tin[], int low[], List<List<Integer>> bridges) {
        vis[node] = 1; // Mark the current node as visited
        tin[node] = low[node] = timer; // Initialize discovery time and low value
        timer++; // Increment the timer for the next node

        // Explore all adjacent nodes
        for (Integer it : adj.get(node)) {
            if (it == parent) {
                continue; // Skip the parent node
            }
            if (vis[it] == 0) { // If the node is not visited
                dfs(it, node, vis, adj, tin, low, bridges); // Recur for the adjacent node
                low[node] = Math.min(low[it], low[node]); // Update low value for the current node

                // Check if the edge is a bridge
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node)); // Add the bridge to the list
                }
            } else {
                low[node] = Math.min(low[it], low[node]); // Update low value if the adjacent node is visited
            }
        }
    }
}
