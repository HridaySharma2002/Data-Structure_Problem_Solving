class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int result = 0;               // To store the last day crossing is possible
        int left = 1;                 // Binary search start (day 1)
        int right = cells.length;     // Binary search end (last day)
        
        // Binary search to find the latest day you can cross
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Middle day to check
            
            // Check if crossing is possible on 'mid' day
            if (canCross(mid, row, col, cells)) {
                result = mid;          // Update result to current day
                left = mid + 1;        // Try to find a later day
            } else {
                right = mid - 1;       // Try earlier days if crossing not possible
            }
        }
        
        return result;                // Return the last day crossing is possible
    }
    
    // Helper method to check if crossing is possible on a given day
    private boolean canCross(int day, int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];  // Grid representing land(0) and water(1)
        
        // Flood the first 'day' cells as water (1)
        for (int i = 0; i < day; i++) {
            // Convert 1-based coordinates to 0-based indices
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        Queue<int[]> queue = new LinkedList<>();  // Queue for BFS
        boolean[][] visited = new boolean[row][col];  // Track visited cells
        
        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        // Add all land cells in the top row to the BFS queue
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {          // If cell is land
                queue.offer(new int[]{0, c});
                visited[0][c] = true;       // Mark as visited
            }
        }
        
        // BFS to find a path from top to bottom row
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            // If reached bottom row, crossing is possible
            if (r == row - 1) {
                return true;
            }
            
            // Explore all 4 directions
            for (int[] dir : directions) {
                int nrow = r + dir[0];
                int ncol = c + dir[1];
                
                // Check boundaries, not visited, and land cell
                if (nrow >= 0 && nrow < row && ncol >= 0 && ncol < col &&
                    !visited[nrow][ncol] && grid[nrow][ncol] == 0) {
                    queue.offer(new int[]{nrow, ncol});
                    visited[nrow][ncol] = true;  // Mark new cell as visited
                }
            }
        }
        
        // No path found to bottom row
        return false;
    }
}
