class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length; // Get the number of rows in the grid
        int m = grid[0].length; // Get the number of columns in the grid
        int vis[][] = new int[n][m]; // Create a visited array to track visited cells

        Queue<int[]> queue = new LinkedList<>(); // Initialize a queue for BFS

        // Add all '1's on the boundary to the queue and mark them as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) { // Check if the cell is on the boundary
                    if (grid[i][j] == 1) { // If the cell is land ('1')
                        queue.add(new int[]{i, j}); // Add the cell to the queue
                        vis[i][j] = 1; // Mark the cell as visited
                    }
                }
            }
        }

        // Direction vectors for moving up, right, down, and left
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // Perform BFS to mark all reachable '1's from the boundary
        while (!queue.isEmpty()) {
            int cell[] = queue.poll(); // Get the front cell from the queue
            int row = cell[0]; // Current row
            int col = cell[1]; // Current column

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i]; // Calculate new row index
                int ncol = col + delcol[i]; // Calculate new column index

                // Check if the new position is valid and unvisited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = 1; // Mark the new cell as visited
                    queue.add(new int[]{nrow, ncol}); // Add the new cell to the queue
                }
            }
        }

        // Count the number of '1's that are not reachable from the boundary
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) { // If the cell is land and not visited
                    count++; // Increment the count of enclaves
                }
            }
        }

        return count; // Return the total count of enclaves
    }
}
