class Solution {

    // Space Optimization
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int prev[] = new int[m]; // Array to store the previous row's minimum path sums

        // Initialize the first row of prev with the first row of the matrix
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        // Iterate through each row starting from the second row
        for (int i = 1; i < n; i++) {
            int cur[] = new int[m]; // Array to store the current row's minimum path sums
            for (int j = 0; j < m; j++) {
                // Calculate the minimum path sum coming from the row above
                int up = matrix[i][j] + prev[j]; // Coming straight down
                int ld = matrix[i][j]; // Coming from the left diagonal
                if (j - 1 >= 0) {
                    ld += prev[j - 1]; // Add the left diagonal value if within bounds
                } else {
                    ld += (int) 1e9; // If out of bounds, add a large value
                }
                int rd = matrix[i][j]; // Coming from the right diagonal
                if (j + 1 < m) {
                    rd += prev[j + 1]; // Add the right diagonal value if within bounds
                } else {
                    rd += (int) 1e9; // If out of bounds, add a large value
                }

                // Store the minimum path sum for the current cell
                cur[j] = Math.min(up, Math.min(ld, rd));
            }
            prev = cur; // Move to the next row
        }

        // Find the minimum path sum from the last row
        int mini = (int) 1e9;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini; // Return the minimum falling path sum
    }

    // Tabulation (Dynamic Programming)
    /*
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int dp[][] = new int[n][m]; // DP table to store minimum path sums

        // Initialize the first row of dp with the first row of the matrix
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j]; // Coming straight down
                int ld = matrix[i][j]; // Coming from the left diagonal
                if (j - 1 >= 0) {
                    ld += dp[i - 1][j - 1]; // Add the left diagonal value if within bounds
                } else {
                    ld += (int) 1e9; // If out of bounds, add a large value
                }
                int rd = matrix[i][j]; // Coming from the right diagonal
                if (j + 1 < m) {
                    rd += dp[i - 1][j + 1]; // Add the right diagonal value if within bounds
                } else {
                    rd += (int) 1e9; // If out of bounds, add a large value
                }

                // Store the minimum path sum for the current cell
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        // Find the minimum path sum from the last row
        int mini = (int) 1e9;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini; // Return the minimum falling path sum
    }
    */

    // Memoization (Recursive with caching)
    /*
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int dp[][] = new int[n][m]; // DP table for memoization
        int mini = (int) 1e9;

        // Calculate the minimum path sum starting from each column in the last row
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, help(n - 1, j, matrix, dp));
        }
        return mini; // Return the minimum falling path sum
    }

    private int help(int i, int j, int[][] matrix, int dp[][]) {
        // Check for out-of-bounds indices
        if (j < 0 || j >= matrix[0].length) {
            return (int) 1e9; // Return a large value if out of bounds
        }
        if (i == 0) {
            return matrix[0][j]; // Base case: return the value at the top row
        }
        if (dp[i][j] != 0) {
            return dp[i][j]; // Return cached result if already computed
        }

        // Calculate the minimum path sum from the three possible directions
        int up = matrix[i][j] + help(i - 1, j, matrix, dp); // Coming straight down
        int ld = matrix[i][j] + help(i - 1, j - 1, matrix, dp); // Coming from the left diagonal
        int rd = matrix[i][j] + help(i - 1, j + 1, matrix, dp); // Coming from the right diagonal

        // Store and return the minimum path sum for the current cell
        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }
    */
}
