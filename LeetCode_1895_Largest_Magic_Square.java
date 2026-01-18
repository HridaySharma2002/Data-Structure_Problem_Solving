class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;         // Number of rows in the grid
        int m = grid[0].length;      // Number of columns in the grid
        if (n < 2 || m < 2) return 1; // If grid is too small, only 1x1 magic square is possible

        // Prefix sums for rows, columns, and both diagonals
        long[][] row = new long[n][m + 1];      // row[i][j+1]: sum of row i from column 0 to j
        long[][] col = new long[n + 1][m];      // col[i+1][j]: sum of column j from row 0 to i
        long[][] d1 = new long[n + 1][m + 2];   // d1[i+1][j+1]: sum of main diagonal up to (i, j)
        long[][] d2 = new long[n + 1][m + 2];   // d2[i+1][j]: sum of anti-diagonal up to (i, j)

        // Compute prefix sums for rows, columns, and diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];           // Row prefix sum
                col[i + 1][j] = col[i][j] + grid[i][j];           // Column prefix sum
                d1[i + 1][j + 1] = d1[i][j] + grid[i][j];         // Main diagonal prefix sum
                d2[i + 1][j] = d2[i][j + 1] + grid[i][j];         // Anti-diagonal prefix sum
            }
        }

        // Try all possible square sizes from largest to smallest
        for (int k = Math.min(n, m); k > 1; k--) { // k: current square size
            for (int r = 0; r <= n - k; r++) {     // r: top row of square
                for (int c = 0; c <= m - k; c++) { // c: left column of square
                    // Target sum is the sum of the first row in the current square
                    long target = row[r][c + k] - row[r][c];

                    // Check main diagonal sum
                    if (d1[r + k][c + k] - d1[r][c] != target) continue;
                    // Check anti-diagonal sum
                    if (d2[r + k][c] - d2[r][c + k] != target) continue;

                    boolean match = true;
                    // Check all rows in the square
                    for (int i = 0; i < k; i++) {
                        if (row[r + i][c + k] - row[r + i][c] != target) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) continue;

                    // Check all columns in the square
                    for (int j = 0; j < k; j++) {
                        if (col[r + k][c + j] - col[r][c + j] != target) {
                            match = false;
                            break;
                        }
                    }

                    // If all checks pass, return the current size
                    if (match) return k;
                }
            }
        }
        // If no magic square larger than 1x1 is found, return 1
        return 1;
    }
}
