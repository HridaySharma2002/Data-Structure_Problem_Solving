class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Check if the starting or ending cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // No clear path if start or end is blocked
        }

        // Directions for 8 possible moves (horizontal, vertical, diagonal)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Up, Down, Left, Right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonal moves
        };

        // Queue for BFS, storing {row, col, distance}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // Start from the top-left corner with distance 1

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // Get the current cell
            int row = current[0]; // Current row
            int col = current[1]; // Current column
            int distance = current[2]; // Current distance from the start

            // Check if we reached the bottom-right corner
            if (row == n - 1 && col == n - 1) {
                return distance; // Return the distance if destination is reached
            }

            // Explore all 8 possible directions
            for (int[] dir : directions) {
                int nrow = row + dir[0]; // New row after moving in the direction
                int ncol = col + dir[1]; // New column after moving in the direction

                // Check if the new position is within bounds and is a clear cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0) {
                    grid[nrow][ncol] = 1; // Mark the cell as visited
                    queue.offer(new int[]{nrow, ncol, distance + 1}); // Add new position to the queue with updated distance
                }
            }
        }

        // If we exhaust the queue without finding a path, return -1
        return -1; // No clear path exists
    }
}
