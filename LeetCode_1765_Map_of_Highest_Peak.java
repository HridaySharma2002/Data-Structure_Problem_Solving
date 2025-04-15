class Solution {
    public int[][] highestPeak(int[][] isWater) {
        // Get the number of rows (n) and columns (m) in the input matrix
        int n = isWater.length;
        int m = isWater[0].length;
        
        // Create a distance matrix to store the height of each cell
        int dis[][] = new int[n][m];
        // Initialize a queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Populate the distance matrix and queue with water cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    // Water cells have a height of 0
                    dis[i][j] = 0;
                    // Add water cell coordinates to the queue
                    queue.add(new int[]{i, j});
                } else {
                    // Land cells are initialized to maximum value (not reachable yet)
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions for moving up, down, left, and right
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // Perform BFS to calculate the height of each land cell
        while (!queue.isEmpty()) {
            // Get the current cell from the queue
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i]; // New row index
                int ncol = col + delcol[i]; // New column index

                // Check if the new position is within bounds
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    // If the new cell is land and we found a shorter distance
                    if (dis[nrow][ncol] > dis[row][col] + 1) {
                        // Update the distance for the new cell
                        dis[nrow][ncol] = dis[row][col] + 1;
                        // Add the new cell to the queue for further exploration
                        queue.add(new int[]{nrow, ncol});
                    }
                }
            }
        }

        // Return the distance matrix representing the height of each cell
        return dis;
    }
}
