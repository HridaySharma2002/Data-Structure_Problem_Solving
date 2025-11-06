class Solution {
    // Main method to process queries on the graph
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Initialize adjacency list for graph with c nodes (0-indexed)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            adj.add(new ArrayList<>());  // Add empty list for each node
        }

        // Build undirected graph from connections (1-indexed to 0-indexed)
        for (int[] it : connections) {
            int u = it[0] - 1;  // Convert to zero-based index
            int v = it[1] - 1;
            adj.get(u).add(v);  // Add edge u -> v
            adj.get(v).add(u);  // Add edge v -> u (undirected)
        }

        // Arrays to track visited nodes for DFS and online status of nodes
        boolean vis[] = new boolean[c];
        boolean online[] = new boolean[c];
        Arrays.fill(online, true);  // Initially, all nodes are online

        // Map to store connected components:
        // key = component id, value = sorted set of online nodes in that component
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        // Map to store which component each node belongs to
        Map<Integer, Integer> mpp = new HashMap<>();

        int id = 0;  // Component id counter

        // Find connected components using DFS
        for (int i = 0; i < c; i++) {
            if (!vis[i]) {
                map.put(id, new TreeSet<>());  // Initialize TreeSet for this component
                dfs(id, i, adj, vis, map, mpp);  // DFS to mark all nodes in this component
                id++;  // Increment component id for next component
            }
        }

        // List to store answers for type 1 queries
        List<Integer> resultlist = new ArrayList<>();

        // Process each query
        for (int[] q : queries) {
            int type = q[0];          // Query type (1 or 2)
            int node = q[1] - 1;      // Node index (0-based)
            int compId = mpp.get(node);  // Component id of the node

            if (type == 2) {
                // Type 2 query: take node offline
                map.get(compId).remove(node);  // Remove node from online set of component
                online[node] = false;           // Mark node offline
                continue;                      // No output for type 2 queries
            }

            // Type 1 query: find node or fallback node in component
            if (online[node]) {
                // If node is online, answer is the node itself (convert back to 1-based)
                resultlist.add(node + 1);
            } else if (!map.get(compId).isEmpty()) {
                // If node offline, return smallest online node in the same component
                resultlist.add(map.get(compId).first() + 1);
            } else {
                // If no online nodes in component, answer is -1
                resultlist.add(-1);
            }
        }

        // Convert result list to array for return
        int[] result = new int[resultlist.size()];
        for (int i = 0; i < resultlist.size(); i++) {
            result[i] = resultlist.get(i);
        }

        return result;
    }

    // DFS helper method to find connected components
    private void dfs(int id, int node, List<List<Integer>> adj, boolean[] vis,
                     Map<Integer, TreeSet<Integer>> map, Map<Integer, Integer> mpp) {
        vis[node] = true;           // Mark current node as visited
        map.get(id).add(node);      // Add node to TreeSet of current component
        mpp.put(node, id);          // Map node to its component id

        // Visit all neighbors of current node
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(id, it, adj, vis, map, mpp);  // Recursive DFS call
            }
        }
    }
}
