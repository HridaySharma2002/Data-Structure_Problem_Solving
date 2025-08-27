class Solution {
    public int countSquares(int[][] matrix) {
        // Check for null or empty matrix
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int n = matrix.length;      // Number of rows
        int m = matrix[0].length;   // Number of columns
        int result = 0;             // To store the total count of square submatrices
        
        // Iterate through each cell of the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If the current cell is 1 and not in the first row or first column
                if(matrix[i][j] == 1 && i > 0 && j > 0){
                    // Update the cell with the size of the largest square ending at (i, j)
                    // by taking the minimum of top, left, and top-left neighbors and adding 1
                    matrix[i][j] = Math.min(
                        matrix[i-1][j-1], 
                        Math.min(matrix[i-1][j], matrix[i][j-1])
                    ) + 1;
                }
                // Add the value at matrix[i][j] to the result
                // This works because the value now represents the number of squares ending at (i, j)
                result += matrix[i][j];
            }
        }
        // Return the total count of square submatrices with all ones
        return result;
    }
}
