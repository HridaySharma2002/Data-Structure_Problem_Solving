class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length; // Get the size of the grid (n x n)
        boolean vis[][] = new boolean[n][n]; // Visited array to track which cells have been visited
        // Priority queue to store cells based on their elevation, sorted in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        
        // Start from the top-left corner (0, 0) with its elevation
        pq.offer(new int[]{grid[0][0], 0, 0}); // {elevation, row, column}
        vis[0][0] = true; // Mark the starting cell as visited
        
        // Directions for moving in the grid (right, down, left, up)
        int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Process the priority queue until it's empty
        while (!pq.isEmpty()) {
            int current[] = pq.poll(); // Get the cell with the lowest elevation
            int elevation = current[0]; // Current elevation
            int row = current[1]; // Current row index
            int col = current[2]; // Current column index

            // If we reach the bottom-right corner, return the elevation
            if (row == n - 1 && col == n - 1) {
                return elevation; // This is the least time required to swim to (n-1, n-1)
            }

            // Explore the 4 possible directions from the current cell
            for (int dir[] : directions) {
                int nrow = row + dir[0]; // New row index
                int ncol = col + dir[1]; // New column index
                
                // Check if the new position is within bounds and not visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true; // Mark the new cell as visited
                    // Add the new cell to the priority queue with the maximum elevation encountered so far
                    pq.offer(new int[]{Math.max(grid[nrow][ncol], elevation), nrow, ncol});
                }
            }
        }
        
        return -1; // In case there is no path (should not happen with valid input)
    }
}
