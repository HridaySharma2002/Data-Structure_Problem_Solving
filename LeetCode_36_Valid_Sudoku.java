class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Boolean arrays to keep track of seen digits in rows, columns, and boxes
        // rows[i][num] = true means digit (num+1) has been seen in row i
        boolean[][] rows = new boolean[9][9];
        // cols[j][num] = true means digit (num+1) has been seen in column j
        boolean[][] cols = new boolean[9][9];
        // boxes[boxIndex][num] = true means digit (num+1) has been seen in 3x3 box boxIndex
        boolean[][] boxes = new boolean[9][9];

        // Iterate over each cell in the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Process only filled cells (not '.')
                if (board[i][j] != '.') {
                    // Convert character digit to zero-based index (e.g., '1' -> 0, '9' -> 8)
                    int num = board[i][j] - '1';

                    // Calculate index of the 3x3 box the cell belongs to
                    // Boxes are numbered 0 to 8 from left to right, top to bottom
                    int boxindex = (i / 3) * 3 + (j / 3);

                    // Check if this digit has already been seen in the current row, column, or box
                    if (rows[i][num] || cols[j][num] || boxes[boxindex][num]) {
                        // If yes, the Sudoku board is invalid
                        return false;
                    }

                    // Mark the digit as seen in the current row, column, and box
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxindex][num] = true;
                }
            }
        }
        // If no conflicts found, the Sudoku board is valid
        return true;
    }
}
