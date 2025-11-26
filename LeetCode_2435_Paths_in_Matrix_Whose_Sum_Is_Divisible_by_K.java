class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        // MOD is used to keep the result within integer limits (as required by the problem)
        int MOD = (int)1e9 + 7;

        // m: number of rows, n: number of columns in the grid
        int m = grid.length;
        int n = grid[0].length;

        // prev and curr are rolling DP arrays.
        // prev[j][r]: number of ways to reach cell in previous row at column j with sum % k == r
        // curr[j][r]: number of ways to reach cell in current row at column j with sum % k == r
        int[][] prev = new int[n][k];
        int[][] curr = new int[n][k];

        // Initialize the first row: can only move right, so only one path to each cell
        int sum = 0; // Cumulative sum for the first row
        for (int j = 0; j < n; j++) {
            sum = (sum + grid[0][j]) % k; // Update sum modulo k
            prev[j][sum] = 1; // There is exactly one way to reach (0, j) with this remainder
        }

        // Reset sum for the first column of subsequent rows (moving only down)
        sum = grid[0][0] % k;

        // Process each row starting from the second row
        for (int i = 1; i < m; i++) {
            // Update sum for the first column (only downward movement)
            sum = (sum + grid[i][0]) % k;
            Arrays.fill(curr[0], 0); // Clear current DP state for column 0
            curr[0][sum] = 1; // Only one way to reach (i, 0) with this remainder

            // Process the rest of the columns in the current row
            for (int j = 1; j < n; j++) {
                Arrays.fill(curr[j], 0); // Clear current DP state for column j
                int val = grid[i][j]; // Value at current cell

                // For each possible previous remainder, update the new remainder
                for (int r = 0; r < k; r++) {
                    int nr = (r + val) % k; // New remainder after adding current cell's value

                    // DP Transition:
                    // - prev[j][r]: number of ways to reach from above (i-1, j) with remainder r
                    // - curr[j-1][r]: number of ways to reach from left (i, j-1) with remainder r
                    // Add both ways and take modulo MOD
                    curr[j][nr] = (prev[j][r] + curr[j - 1][r]) % MOD;
                }
            }

            // Rolling array optimization: swap prev and curr for the next row
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        // The answer is the number of ways to reach the bottom-right cell with sum % k == 0
        return prev[n - 1][0];
    }
}
