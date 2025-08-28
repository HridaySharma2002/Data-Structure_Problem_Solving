class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // Handle the edge case where the input matrix is null or empty
        if(mat == null || mat.length == 0){
            return new int[0];
        }
        
        int m = mat.length;      // Number of rows
        int n = mat[0].length;   // Number of columns
        int row = 0, col = 0;    // Starting position
        
        int result[] = new int[m * n]; // Array to store the diagonal order
        
        // Iterate through all elements in the matrix
        for(int i = 0; i < m * n; i++){
            result[i] = mat[row][col]; // Add current element to result
            
            // Determine the direction based on the sum of row and col
            if((row + col) % 2 == 0){ // Moving up-right
                if(col == n - 1){     // If at the last column, move down to next row
                    row++;
                } else if(row == 0){  // If at the first row, move right to next column
                    col++;
                } else {              // Otherwise, move up and right
                    row--;
                    col++;
                }
            } else {                  // Moving down-left
                if(row == m - 1){     // If at the last row, move right to next column
                    col++;
                } else if(col == 0){  // If at the first column, move down to next row
                    row++;
                } else {              // Otherwise, move down and left
                    row++;
                    col--;
                }
            }
        }
        
        return result; // Return the diagonal traversal
    }
}
