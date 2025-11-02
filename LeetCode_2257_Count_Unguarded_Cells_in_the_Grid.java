class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Create a 2D grid representing the m x n board
        // 0 = empty cell, 1 = guard, 2 = wall, 3 = guarded cell
        int[][] grid = new int[m][n];

        // Mark all wall positions in the grid as 2
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Mark all guard positions in the grid as 1
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }

        // Directions array representing Up, Down, Left, Right movements
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // For each guard, mark all cells visible in the four directions
        for (int[] g : guards) {
            int row = g[0];
            int col = g[1];

            // Explore each direction from the guard's position
            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                // Move step-by-step in the current direction until hitting a wall or another guard or boundary
                while (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    // Stop if we encounter a wall (2) or another guard (1)
                    if (grid[nrow][ncol] == 2 || grid[nrow][ncol] == 1) {
                        break;
                    }
                    // If the cell is empty (0), mark it as guarded (3)
                    if (grid[nrow][ncol] == 0) {
                        grid[nrow][ncol] = 3;
                    }
                    // Move further in the same direction
                    nrow += dir[0];
                    ncol += dir[1];
                }
            }
        }

        // Count the number of cells that remain empty (0), i.e., unguarded and unoccupied
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result++;
                }
            }
        }

        // Return the count of unguarded cells
        return result;
    }
}
