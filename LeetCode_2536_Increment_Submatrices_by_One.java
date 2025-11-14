class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // Initialize the result matrix (difference matrix) with zeros
        int result[][] = new int[n][n];
        
        // Step 1: Apply each query to the difference matrix
        for (int q[] : queries) {
            int r1 = q[0];  // top row of submatrix
            int c1 = q[1];  // left column of submatrix
            int r2 = q[2];  // bottom row of submatrix
            int c2 = q[3];  // right column of submatrix
            
            // Increment at the top-left corner of the submatrix
            result[r1][c1]++;
            
            // Decrement just below the bottom boundary if within matrix bounds
            if (r2 + 1 < n) {
                result[r2 + 1][c1]--;
            }
            
            // Decrement just right of the right boundary if within matrix bounds
            if (c2 + 1 < n) {
                result[r1][c2 + 1]--;
            }
            
            // Add back 1 at the bottom-right corner outside the submatrix to fix double subtraction
            if (r2 + 1 < n && c2 + 1 < n) {
                result[r2 + 1][c2 + 1]++;
            }
        }
        
        // Step 2: Build the final matrix by computing prefix sums over rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Value from the cell above (if exists)
                int above = i > 0 ? result[i - 1][j] : 0;
                
                // Value from the cell to the left (if exists)
                int left = j > 0 ? result[i][j - 1] : 0;
                
                // Value from the diagonal top-left cell (if exists)
                int diag = (i > 0 && j > 0) ? result[i - 1][j - 1] : 0;
                
                // Update current cell by adding prefix sums and subtracting overlap
                result[i][j] += above + left - diag;
            }
        }
        
        // Return the final matrix after all increments
        return result;
    }
}
