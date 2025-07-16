class Solution {
    // Space Optimization approach to find the minimum path sum in a triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); // Get the number of rows in the triangle
        int front[] = new int[n]; // Array to store the minimum path sums for the previous row

        // Initialize the front array with the values from the last row of the triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j); // Fill front with the last row values
        }

        // Iterate from the second last row to the top of the triangle
        for (int i = n - 2; i >= 0; i--) {
            int cur[] = new int[n]; // Array to store the minimum path sums for the current row

            // Iterate through the current row elements
            for (int j = i; j >= 0; j--) {
                // Calculate the minimum path sum by moving down or diagonally
                int down = triangle.get(i).get(j) + front[j]; // Path going straight down
                int diag = triangle.get(i).get(j) + front[j + 1]; // Path going diagonally down-right

                // Store the minimum of the two paths in the cur array
                cur[j] = Math.min(down, diag);
            }

            // Update the front array to be the current row's minimum path sums
            front = cur; // Move to the next row
        }

        // The minimum path sum from top to bottom is now at the top of the front array
        return front[0]; // Return the minimum path sum
    }

    // Tabulation approach (commented out)
    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); // Get the number of rows in the triangle
        int dp[][] = new int[n][n]; // Create a DP table to store minimum path sums

        // Initialize the last row of the DP table with the last row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Fill the DP table from the second last row to the top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the minimum path sum for the current cell
                int down = triangle.get(i).get(j) + dp[i + 1][j]; // Path going straight down
                int diag = triangle.get(i).get(j) + dp[i + 1][j + 1]; // Path going diagonally down-right
                dp[i][j] = Math.min(down, diag); // Store the minimum path sum
            }
        }

        // The minimum path sum from top to bottom is at the top of the DP table
        return dp[0][0]; // Return the minimum path sum
    }*/
    
    // Memoization approach (commented out)
    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); // Get the number of rows in the triangle
        int dp[][] = new int[n][n]; // Create a DP table to store minimum path sums

        // Initialize the DP table with -1 to indicate uncomputed values
        for (int rows[] : dp) {
            Arrays.fill(rows, -1); // Fill each row with -1
        }

        // Start the recursive helper function from the top of the triangle
        return help(0, 0, dp, n, triangle);
    }

    // Helper function for memoization
    private int help(int i, int j, int dp[][], int n, List<List<Integer>> triangle) {
        // Base case: if we reach the last row, return the value at that position
        if (i == n - 1) {
            return triangle.get(n - 1).get(j);
        }

        // If the value has already been computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Calculate the minimum path sum by moving down or diagonally
        int down = triangle.get(i).get(j) + help(i + 1, j, dp, n, triangle); // Path going straight down
        int diag = triangle.get(i).get(j) + help(i + 1, j + 1, dp, n, triangle); // Path going diagonally down-right

        // Store the minimum path sum in the DP table and return it
        return dp[i][j] = Math.min(down, diag);
    }*/
}
