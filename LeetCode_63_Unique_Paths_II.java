class Solution {
    // Space Optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // Number of rows
        int n = obstacleGrid[0].length; // Number of columns
        
        // If the starting cell or ending cell has an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        // Array to store the number of unique paths to each cell in the current row
        int prev[] = new int[n]; // Change to n since we are using a single row
        
        // Initialize the first cell
        prev[0] = 1; // There's one way to reach the starting cell if it's not an obstacle
        
        // Iterate through each row
        for (int i = 0; i < m; i++) {
            // Iterate through each column
            for (int j = 0; j < n; j++) {
                // If there is an obstacle at the current cell, set paths to 0
                if (obstacleGrid[i][j] == 1) {
                    prev[j] = 0; // No paths through this cell
                } 
                // If we are not in the first row or first column
                else if (i > 0 || j > 0) {
                    // Calculate paths from the top and left cells
                    int up = (i > 0) ? prev[j] : 0; // Paths from the cell above
                    int left = (j > 0) ? prev[j - 1] : 0; // Paths from the cell to the left
                    prev[j] = up + left; // Total paths to the current cell
                }
            }
        }
        // The bottom-right cell contains the total unique paths
        return prev[n - 1]; // Return the number of unique paths to the bottom-right cell
    }
}
