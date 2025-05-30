class Solution {
    // Helper class to store the distance and coordinates of each cell
    class Pair {
        int distance; // The current effort to reach this cell
        int row;      // The row index of the cell
        int col;      // The column index of the cell
        
        // Constructor to initialize the Pair object
        Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; // Number of rows
        int m = heights[0].length; // Number of columns
        
        // Distance array to track the minimum effort to reach each cell
        int dist[][] = new int[n][m];
        
        // Initialize the distance array with a large value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9); // Set initial distances to a large number
            }
        }
        
        dist[0][0] = 0; // Starting point has zero effort

        // Priority queue to process cells based on the minimum effort
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(0, 0, 0)); // Start from the top-left corner with distance 0

        // Directions for moving up, down, left, and right
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // Perform Dijkstra's algorithm using the priority queue
        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the cell with the minimum effort
            int row = current.row; // Current row index
            int col = current.col; // Current column index
            int diff = current.distance; // Current effort to reach this cell

            // If we reach the bottom-right corner, return the effort
            if (row == n - 1 && col == m - 1) {
                return diff; // Return the minimum effort to reach the destination
            }

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i]; // New row after moving in the direction
                int ncol = col + dc[i]; // New column after moving in the direction
                
                // Check if the new position is within bounds
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    // Calculate the new effort required to move to the neighboring cell
                    int neweffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    
                    // If the new effort is less than the previously recorded effort, update it
                    if (neweffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = neweffort; // Update the distance array
                        pq.offer(new Pair(neweffort, nrow, ncol)); // Add the new position to the priority queue
                    }
                }
            }
        }

        return 0; // If no path is found, return 0 (though this case should not occur)
    }
}
