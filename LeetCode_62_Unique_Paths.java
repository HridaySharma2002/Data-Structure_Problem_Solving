class Solution {
    // Space Optimization
    public int uniquePaths(int m, int n) {
        // Array to store the number of unique paths to each cell in the current row
        int prev[] = new int[m];
        
        // Iterate through each row
        for (int i = 0; i < m; i++) {
            // Array to store the number of unique paths to each cell in the current column
            int curr[] = new int[n];
            
            // Iterate through each column
            for (int j = 0; j < n; j++) {
                // If we are in the first row or first column, there is only one way to reach that cell
                if (i == 0 || j == 0) {
                    curr[j] = 1;
                } else {
                    // Initialize paths from the top and left cells
                    int up = 0;
                    int left = 0;
                    
                    // Get the number of paths from the cell above
                    if (i > 0) {
                        up = prev[j];
                    }
                    // Get the number of paths from the cell to the left
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    // The current cell's paths are the sum of paths from the top and left cells
                    curr[j] = up + left;
                }
            }
            // Move to the next row, updating the previous row's paths
            prev = curr;
        }
        // The bottom-right cell contains the total unique paths
        return prev[n - 1];
    }

    // Tabulation
    // public int uniquePaths(int m, int n) {
    //     int dp[][] = new int[m][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (i == 0 || j == 0) {
    //                 dp[i][j] = 1; // Initialize first row and column to 1
    //             } else {
    //                 int up = 0;
    //                 int left = 0;
    //                 if (i > 0) {
    //                     up = dp[i - 1][j]; // Paths from the cell above
    //                 }
    //                 if (j > 0) {
    //                     left = dp[i][j - 1]; // Paths from the cell to the left
    //                 }
    //                 dp[i][j] = up + left; // Total paths to the current cell
    //             }
    //         }
    //     }
    //     return dp[m - 1][n - 1]; // Return the total unique paths
    // }

    // Memoization
    // public int uniquePaths(int m, int n) {
    //     int dp[][] = new int[m][n];
    //     for (int row[] : dp) {
    //         Arrays.fill(row, -1); // Initialize memoization table with -1
    //     }
    //     return help(m - 1, n - 1, dp); // Start recursion from the bottom-right cell
    // }
    // private int help(int i, int j, int dp[][]) {
    //     if (i == 0 || j == 0) {
    //         return 1; // Base case: only one way to reach the first row or column
    //     }
    //     if (i < 0 || j < 0) {
    //         return 0; // Out of bounds
    //     }
    //     if (dp[i][j] != -1) {
    //         return dp[i][j]; // Return already computed value
    //     }
    //     int up = help(i - 1, j, dp); // Recursive call for the cell above
    //     int down = help(i, j - 1, dp); // Recursive call for the cell to the left

    //     return dp[i][j] = up + down; // Store and return the total paths
    // }
}
