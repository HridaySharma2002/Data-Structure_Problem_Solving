class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;      // Number of rows in the grid
        int m = grid[0].length;   // Number of columns in the grid

        // Find the maximum value in the grid to size helper arrays
        int maxval = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxval = Math.max(maxval, val);
            }
        }

        int dp[][] = new int[n][m];              // DP array: dp[i][j] = min cost to reach (n-1, m-1) from (i, j)
        int temp[] = new int[maxval + 1];        // temp[v] = min cost to reach end from any cell with value v
        int best[] = new int[maxval + 1];        // best[v] = min temp[0..v], used for teleportation

        // Initialize temp with infinity
        Arrays.fill(temp, Integer.MAX_VALUE);

        // The cost to reach the end from the end is 0
        temp[grid[n - 1][m - 1]] = 0;

        // Fill dp and temp arrays for the base case (no teleportation)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    continue; // Skip the end cell
                }
                // Cost to move down or right, or infinity if out of bounds
                int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(down, right);

                // Update temp for this cell's value if a path exists
                if (dp[i][j] != Integer.MAX_VALUE) {
                    temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
                }
            }
        }

        // Repeat the process k times to allow up to k teleportations
        for (int x = 0; x < k; x++) {
            // Build the best[] array: best[v] = min(temp[0..v])
            best[0] = temp[0];
            for (int v = 1; v <= maxval; v++) {
                best[v] = Math.min(best[v - 1], temp[v]);
            }

            // Update dp and temp arrays considering teleportation
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == n - 1 && j == m - 1) {
                        continue; // Skip the end cell
                    }
                    // Cost to walk to neighbor cells
                    int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                    int walkcost = Math.min(down, right);

                    // Cost to teleport to any cell with value <= grid[i][j]
                    int teleportcost = best[grid[i][j]];

                    // Take the minimum of walking or teleporting
                    dp[i][j] = Math.min(walkcost, teleportcost);

                    // Update temp for this cell's value if a path exists
                    if (dp[i][j] != Integer.MAX_VALUE) {
                        temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
                    }
                }
            }
        }

        // The answer is the minimum cost to reach the end from the start
        return dp[0][0];
    }
}
