class Solution {
    // This method finds the number of islands in the given grid
    public int numIslands(char[][] grid) {
        // Check for edge cases: if the grid is null or empty
        if (grid == null || grid.length == 0) {
            return 0; // No islands if the grid is empty
        }
        
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        boolean vis[][] = new boolean[n][m]; // Array to track visited cells
        int count = 0; // Counter for the number of islands
        
        // Iterate through each cell in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // If the cell is land ('1') and not visited, it's a new island
                if (!vis[row][col] && grid[row][col] == '1') {
                    count++; // Increment the island count
                    bfs(row, col, vis, grid); // Perform BFS to mark all connected land
                }
            }
        }
        return count; // Return the total number of islands
    }

    // BFS function to explore all connected land cells
    public void bfs(int ro, int co, boolean vis[][], char grid[][]) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        vis[ro][co] = true; // Mark the starting cell as visited
        Queue<int[]> queue = new LinkedList<>(); // Queue to hold the cells to explore
        queue.add(new int[]{ro, co}); // Add the starting cell to the queue

        // Directions for moving up, down, left, and right
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Continue exploring until there are no more cells in the queue
        while (!queue.isEmpty()) {
            int cell[] = queue.poll(); // Get the current cell from the queue
            int row = cell[0]; // Current row
            int col = cell[1]; // Current column

            // Explore all four possible directions
            for (int[] dir : directions) {
                int nrow = row + dir[0]; // New row after moving in the direction
                int ncol = col + dir[1]; // New column after moving in the direction

                // Check if the new cell is within bounds and is land
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true; // Mark the new cell as visited
                    queue.add(new int[]{nrow, ncol}); // Add the new cell to the queue
                }
            }
        }
    }
}
