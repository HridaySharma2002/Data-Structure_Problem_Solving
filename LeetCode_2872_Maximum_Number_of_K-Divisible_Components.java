class Solution {
    // Class-level variable to keep track of the count of k-divisible components
    private int result = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Initialize adjacency list representation of the graph
        List<Integer> graph[] = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the undirected graph from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Start DFS traversal from node 0 with no parent (-1)
        dfs(graph, 0, -1, values, k);

        // Return the total count of k-divisible components found
        return result;
    }
    private long dfs(List<Integer> graph[], int u, int prev, int[] values, int k) {
        // Start subtree sum with the value of the current node
        long treesum = values[u];

        // Visit all adjacent nodes except the parent
        for (int v : graph[u]) {
            if (v != prev) {
                // Add the sum of the child's subtree
                treesum += dfs(graph, v, u, values, k);
            }
        }

        // If the subtree sum is divisible by k, increment result count
        if (treesum % k == 0) {
            result++;
        }

        // Return the subtree sum to the parent call
        return treesum;
    }
}
