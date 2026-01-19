class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;       // Number of rows in the matrix
        int n = mat[0].length;    // Number of columns in the matrix
        int maxside = Math.min(m, n);  // Maximum possible side length of a square
        
        // Create a prefix sum matrix with an extra row and column (for easier calculations)
        int[][] pref = new int[m + 1][n + 1];
        
        // Compute prefix sums for the matrix
        // pref[i][j] stores the sum of elements in the rectangle from (0,0) to (i-1,j-1)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1] 
                             + pref[i - 1][j] 
                             + pref[i][j - 1] 
                             - pref[i - 1][j - 1];
            }
        }
        
        // Try squares from the largest possible side length down to 1
        while (maxside > 0) {
            // Iterate over all possible top-left corners of squares with side length maxside
            for (int i = 0; i + maxside <= m; i++) {
                for (int j = 0; j + maxside <= n; j++) {
                    // Check if the sum of the current square is within the threshold
                    if (helper(pref, threshold, i, j, maxside)) {
                        return maxside;  // Return immediately if a valid square is found
                    }
                }
            }
            maxside--;  // Decrease the side length and try again
        }
        
        // If no valid square found, return 0
        return 0;
    }
    private boolean helper(int[][] pref, int threshold, int x, int y, int side) {
        int x2 = x + side;  // Bottom row index (exclusive) of the square in prefix matrix
        int y2 = y + side;  // Right column index (exclusive) of the square in prefix matrix
        
        // Calculate the sum of the square using the prefix sums
        int sum = pref[x2][y2] - pref[x][y2] - pref[x2][y] + pref[x][y];
        
        // Return whether the sum is within the threshold
        return sum <= threshold;
    }
}
