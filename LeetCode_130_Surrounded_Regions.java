class Solution {
    public void solve(char[][] board) {
        int n = board.length; // Get the number of rows in the board
        int m = board[0].length; // Get the number of columns in the board
        int vis[][] = new int[n][m]; // Create a visited array to track visited cells
        int delrow[] = {-1, 0, 1, 0}; // Direction vectors for row movement (up, right, down, left)
        int delcol[] = {0, 1, 0, -1}; // Direction vectors for column movement

        // Check the first and last rows for 'O's
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delcol); // Perform DFS from the first row
            }

            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delrow, delcol); // Perform DFS from the last row
            }
        }

        // Check the first and last columns for 'O's
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delcol); // Perform DFS from the first column
            }

            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delrow, delcol); // Perform DFS from the last column
            }
        }

        // Convert all unvisited 'O's to 'X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X'; // Change unvisited 'O's to 'X's
                }
            }
        }
    }

    // Depth-First Search to mark connected 'O's
    public void dfs(int row, int col, int vis[][], char board[][], int delrow[], int delcol[]) {
        vis[row][col] = 1; // Mark the current cell as visited
        int n = board.length; // Get the number of rows in the board
        int m = board[0].length; // Get the number of columns in the board

        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i]; // Calculate new row index
            int ncol = col + delcol[i]; // Calculate new column index

            // Check if the new position is valid and unvisited
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, delrow, delcol); // Recursively call DFS
            }
        }
    }
}
