class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both graphs
        List<List<Integer>> adjA = buildList(edges1);
        List<List<Integer>> adjB = buildList(edges2);
        int n = adjA.size(); // Number of nodes in graph A
        int m = adjB.size(); // Number of nodes in graph B

        // Arrays to store colors of nodes (0 or 1) and initialize them to -1
        int[] colorA = new int[n];
        int[] colorB = new int[m];
        Arrays.fill(colorA, -1);
        Arrays.fill(colorB, -1);

        // Arrays to count even and odd colored nodes
        int[] countsA = new int[2]; // countsA[0] for even, countsA[1] for odd
        int[] countsB = new int[2]; // countsB[0] for even, countsB[1] for odd
        
        // Start DFS for both graphs from the first node
        colorA[0] = 0; // Color the first node as 0
        dfs(adjA, 0, -1, colorA, true, countsA);
        colorB[0] = 0; // Color the first node as 0
        dfs(adjB, 0, -1, colorB, false, countsB);
        
        // Determine the maximum count of even or odd nodes from graph B
        int maxi = Math.max(countsB[0], countsB[1]);
        int[] result = new int[n]; // Result array to store the final output
        
        // Calculate the result for each node in graph A
        for (int i = 0; i < n; i++) {
            result[i] = (colorA[i] == 0 ? countsA[0] : countsA[1]) + maxi;
        }
        return result; // Return the final result array
    }

    // Method to build the adjacency list from the edges
    List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1; // Number of nodes is edges + 1
        List<List<Integer>> adj = new ArrayList<>(); // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // Create a new list for each node
        }
        // Populate the adjacency list with edges
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]); // Add edge from e[0] to e[1]
            adj.get(e[1]).add(e[0]); // Add edge from e[1] to e[0] (undirected graph)
        }
        return adj; // Return the constructed adjacency list
    }

    // Depth-First Search (DFS) method to traverse the graph
    void dfs(List<List<Integer>> adj, int u, int parent, int[] color, boolean isA, int[] counts) {
        // Increment the count based on the color of the current node
        if (color[u] == 0) {
            counts[0]++; // Even count
        } else {
            counts[1]++; // Odd count
        }

        // Traverse all adjacent nodes
        for (int v : adj.get(u)) {
            if (v != parent) { // Avoid traversing back to the parent node
                color[v] = color[u] ^ 1; // Alternate color for the adjacent node
                dfs(adj, v, u, color, isA, counts); // Recursive DFS call
            }
        }
    }
}
