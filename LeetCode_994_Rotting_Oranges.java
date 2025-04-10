// Class to represent a pair of coordinates and the time taken for the orange to rot
class Pair {
    int row; // Row index of the orange in the grid
    int col; // Column index of the orange in the grid
    int tm;  // Time taken for this orange to rot

    // Constructor to initialize the Pair object
    public Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    // Main method to calculate the minimum time required for all oranges to rot
    public int orangesRotting(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        int vis[][] = new int[n][m]; // Visited array to track rotten oranges
        Queue<Pair> queue = new LinkedList<>(); // Queue for BFS
        int cntfresh = 0; // Counter for fresh oranges

        // Traverse the grid to initialize the queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the orange is rotten, add it to the queue and mark it as visited
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0)); // Add rotten orange to the queue
                    vis[i][j] = 2; // Mark as visited
                } else {
                    vis[i][j] = 0; // Mark as not visited
                }

                // Count the number of fresh oranges
                if (grid[i][j] == 1) {
                    cntfresh++;
                }
            }
        }

        int tm = 0; // Variable to track the maximum time taken
        int count = 0; // Counter for the number of oranges that have rotted
        // Directions for moving up, right, down, and left
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // BFS to rot the fresh oranges
        while (!queue.isEmpty()) {
            int r = queue.peek().row; // Current row
            int c = queue.peek().col; // Current column
            int t = queue.peek().tm; // Time taken for this orange to rot
            tm = Math.max(tm, t); // Update maximum time
            queue.remove(); // Remove the current orange from the queue

            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i]; // New row index
                int ncol = c + delcol[i]; // New column index
                // Check if the new position is valid and contains a fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    queue.add(new Pair(nrow, ncol, t + 1)); // Add the new rotten orange to the queue
                    vis[nrow][ncol] = 2; // Mark as visited
                    count++; // Increment the count of rotted oranges
                }
            }
        }

        // If not all fresh oranges have rotted, return -1
        if (count != cntfresh) {
            return -1;
        }

        // Return the maximum time taken for all oranges to rot
        return tm;
    }
}
