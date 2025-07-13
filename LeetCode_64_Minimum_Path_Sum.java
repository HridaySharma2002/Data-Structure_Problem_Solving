class Solution {
    // Space Optimization
    public int minPathSum(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        int prev[] = new int[m]; // Array to store the previous row's minimum path sums

        // Iterate through each row of the grid
        for (int i = 0; i < n; i++) {
            int cur[] = new int[m]; // Array to store the current row's minimum path sums
            for (int j = 0; j < m; j++) {
                // Base case: top-left corner of the grid
                if (i == 0 && j == 0) {
                    cur[j] = grid[i][j]; // Initialize with the value of the grid cell
                } else {
                    int up = grid[i][j]; // Initialize up path sum with the current cell's value
                    if (i > 0) {
                        up += prev[j]; // Add the value from the cell above if it exists
                    } else {
                        up += (int) 1e9; // Use a large value if out of bounds
                    }

                    int left = grid[i][j]; // Initialize left path sum with the current cell's value
                    if (j > 0) {
                        left += cur[j - 1]; // Add the value from the cell to the left if it exists
                    } else {
                        left += (int) 1e9; // Use a large value if out of bounds
                    }

                    // Store the minimum path sum for the current cell
                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur; // Move to the next row by updating prev to cur
        }
        return prev[m - 1]; // Return the minimum path sum to the bottom-right corner
    }

    // Tabulation
    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int dp[][] = new int[n][m]; // DP array to store minimum path sums
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (i == 0 && j == 0) {
    //                 dp[i][j] = grid[i][j]; // Base case
    //             } else {
    //                 int up = grid[i][j]; // Initialize up path sum
    //                 if (i > 0) {
    //                     up += dp[i - 1][j]; // Add the value from the cell above
    //                 } else {
    //                     up += (int) 1e9; // Use a large value if out of bounds
    //                 }
    //                 int left = grid[i][j]; // Initialize left path sum
    //                 if (j > 0) {
    //                     left += dp[i][j - 1]; // Add the value from the cell to the left
    //                 } else {
    //                     left += (int) 1e9; // Use a large value if out of bounds
    //                 }

    //                 dp[i][j] = Math.min(up, left); // Store the minimum path sum
    //             }
    //         }
    //     }
    //     return dp[n - 1][m - 1]; // Return the minimum path sum to the bottom-right corner
    // }

    // Memoization
    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int dp[][] = new int[n][m]; // DP array for memoization
    //     for (int rows[] : dp) {
    //         Arrays.fill(rows, -1); // Initialize DP array with -1
    //     }
    //     return help(n - 1, m - 1, grid, dp); // Start from the bottom-right corner
    // }

    // private int help(int i, int j, int grid[][], int dp[][]) {
    //     // Base case: if we reach the top-left corner
    //     if (i == 0 && j == 0) {
    //         return grid[0][0]; // Return the value at the top-left corner
    //     }
    //     // Out of bounds
    //     if (i < 0 || j < 0) {
    //         return (int) 1e9; // Return a large value if out of bounds
    //     }
    //     // Return already computed value
    //     if (dp[i][j] != -1) {
    //         return dp[i][j]; // Return the stored result
    //     }
        
    //     // Calculate the minimum path sum from the current cell
    //     int up = grid[i][j] + help(i - 1, j, grid, dp); // Move up
    //     int left = grid[i][j] + help(i, j - 1, grid, dp); // Move left

    //     // Store the result in the DP array and return it
    //     return dp[i][j] = Math.min(up, left); // Return the minimum path sum
    // }
}
