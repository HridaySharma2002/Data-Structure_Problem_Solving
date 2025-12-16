class Solution {
    // Adjacency list to represent the tree structure
    List<Integer>[] tree;
    // Arrays to store present and future values for each node
    int[] present;
    int[] future;
    // 3D DP array: dp[node][bought][budget] stores max profit for subtree rooted at node,
    // where 'bought' indicates if parent bought at half price, and 'budget' is remaining budget
    int[][][] dp;
    // Budget constraint for purchases
    int Budget;

    // Main function to calculate the maximum profit
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.Budget = budget;
        this.present = present;
        this.future = future;
        tree = new ArrayList[n];
        // Initialize adjacency list for the tree
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        // Build the tree from the hierarchy array (convert to 0-based index)
        for (int[] e : hierarchy) {
            tree[e[0] - 1].add(e[1] - 1);
        }
        // Initialize DP array
        dp = new int[n][2][Budget + 1];

        // Start DFS from the root node (assumed to be 0)
        dfs(0);

        // Find the maximum profit achievable within the budget
        int result = 0;
        for (int i = 0; i <= Budget; i++) {
            result = Math.max(result, dp[0][0][i]);
        }
        return result;
    }

    // Helper function to merge two DP arrays for combining subtrees
    private int[] merge(int[] A, int[] B2) {
        int[] C = new int[Budget + 1];
        // Initialize with a very small value to represent impossible states
        Arrays.fill(C, Integer.MIN_VALUE / 2);
        for (int i = 0; i <= Budget; i++) {
            if (A[i] < 0) {
                continue; // Skip impossible states
            }
            for (int j = 0; i + j <= Budget; j++) {
                // Combine profits from both subtrees if total cost is within budget
                C[i + j] = Math.max(C[i + j], A[i] + B2[j]);
            }
        }
        return C;
    }

    // DFS function to fill the DP table for each node
    private void dfs(int u) {
        // Recursively process all children first (post-order traversal)
        for (int v : tree[u]) {
            dfs(v);
        }
        // Try both cases: parent did not buy at half price (bought=0), or did (bought=1)
        for (int bought = 0; bought <= 1; bought++) {
            // Calculate the price to buy this node
            int price = bought == 1 ? present[u] / 2 : present[u];
            // Calculate profit if bought
            int profit = future[u] - price;

            // Case 1: Skip buying this node, just merge all children's dp[0]
            int[] skip = new int[Budget + 1];
            for (int v : tree[u]) {
                skip = merge(skip, dp[v][0]);
            }

            // Case 2: Buy this node, merge all children's dp[1]
            int[] take = new int[Budget + 1];
            Arrays.fill(take, Integer.MIN_VALUE / 2);
            if (price <= Budget) {
                int[] base = new int[Budget + 1];
                for (int v : tree[u]) {
                    base = merge(base, dp[v][1]);
                }
                // Update profit for all possible budgets
                for (int i = price; i <= Budget; i++) {
                    take[i] = base[i - price] + profit;
                }
            }

            // Take the better of skipping or taking for each budget
            for (int i = 0; i <= Budget; i++) {
                dp[u][bought][i] = Math.max(skip[i], take[i]);
            }
        }
    }
}
