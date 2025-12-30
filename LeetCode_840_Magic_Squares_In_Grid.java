class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;       // Number of rows in the grid
        int m = grid[0].length;    // Number of columns in the grid
        int count = 0;             // Counter for magic squares found

        // Iterate over each possible 3x3 subgrid starting point
        // We stop at n-3 and m-3 because the subgrid is of size 3x3
        for (int row = 0; row <= n - 3; row++) {
            for (int col = 0; col <= m - 3; col++) {
                // Check if the current 3x3 subgrid is a magic square
                if (isMagicSquare(grid, row, col)) {
                    count++;  // Increment count if it is a magic square
                }
            }
        }
        return count;  // Return the total count of magic squares found
    }

    // Helper function to check if a 3x3 subgrid starting at (row, col) is a magic square
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean seen[] = new boolean[10];  // Track numbers 1 to 9 to ensure uniqueness

        // Check all numbers in the 3x3 subgrid
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int num = grid[row + r][col + c];
                // If number is not in 1-9 or already seen, it's not a magic square
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;  // Mark number as seen
            }
        }

        // Calculate the sum of the first row to use as reference sum
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        // Check sums of all rows; if any row sum differs, return false
        for (int r = 0; r < 3; r++) {
            int rowSum = grid[row + r][col] + grid[row + r][col + 1] + grid[row + r][col + 2];
            if (sum != rowSum) {
                return false;
            }
        }

        // Check sums of all columns; if any column sum differs, return false
        for (int c = 0; c < 3; c++) {
            int colSum = grid[row][col + c] + grid[row + 1][col + c] + grid[row + 2][col + c];
            if (sum != colSum) {
                return false;
            }
        }

        // Check sum of the main diagonal
        if (sum != grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2]) {
            return false;
        }

        // Check sum of the secondary diagonal
        if (sum != grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2]) {
            return false;
        }

        // If all checks passed, it is a magic square
        return true;
    }
}
