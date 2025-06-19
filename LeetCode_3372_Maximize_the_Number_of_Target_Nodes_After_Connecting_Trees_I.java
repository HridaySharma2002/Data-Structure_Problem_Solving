class Solution {
    // Main method to find the maximum target nodes after connecting two trees
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // Build adjacency lists for both trees from the edge lists
        List<List<Integer>> adj1 = buildList(edges1);
        List<List<Integer>> adj2 = buildList(edges2);
        
        // Variable to keep track of the maximum count of nodes reachable in adj2
        int maxx = 0;
        
        // Iterate through each node in the second tree to find the maximum reachable nodes
        for (int i = 0; i < adj2.size(); i++) {
            maxx = Math.max(maxx, dfs(adj2, i, -1, k - 1));
        }
        
        // Result array to store the maximum target nodes for each node in the first tree
        int result[] = new int[adj1.size()];
        
        // Calculate the maximum target nodes for each node in the first tree
        for (int i = 0; i < adj1.size(); i++) {
            result[i] = dfs(adj1, i, -1, k) + maxx;
        }

        return result; // Return the result array
    }

    // Helper method to build an adjacency list from the edge list
    private List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1; // Number of nodes is edges + 1
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with edges
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]); // Add edge from e[0] to e[1]
            adj.get(e[1]).add(e[0]); // Add edge from e[1] to e[0] (undirected graph)
        }
        return adj; // Return the constructed adjacency list
    }

    // Depth-first search method to count reachable nodes within k steps
    private int dfs(List<List<Integer>> adj, int u, int p, int k) {
        if (k < 0) {
            return 0; // If k is negative, no nodes can be reached
        }
        int cnt = 1; // Count the current node
        // Explore all adjacent nodes
        for (int v : adj.get(u)) {
            if (v != p) { // Avoid going back to the parent node
                cnt += dfs(adj, v, u, k - 1); // Recursively count reachable nodes
            }
        }
        return cnt; // Return the total count of reachable nodes
    }
}
