class Solution {
    public int countNegatives(int[][] grid) {
        // Number of rows in the grid
        int n = grid.length;
        // Number of columns in the grid
        int m = grid[0].length;
        
        // Start from the bottom-left corner of the grid
        int i = n - 1;  // row index starting from last row
        int j = 0;      // column index starting from first column
        
        // Variable to store the count of negative numbers
        int result = 0;
        
        // Traverse the grid while indices are within bounds
        while (i >= 0 && j < m) {
            // If the current element is negative
            if (grid[i][j] < 0) {
                // Since the row is sorted in non-increasing order,
                // all elements to the right of current element are also negative.
                // So add all those elements to the result.
                result += (m - j);
                // Move one row up to check for more negatives
                i--;
            } else {
                // If current element is non-negative,
                // move right to find negative numbers in the same row
                j++;
            }
        }
        
        // Return the total count of negative numbers found
        return result;
    }
}
