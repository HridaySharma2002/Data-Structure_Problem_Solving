class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Get the number of rows (n) and columns (m) in the matrix
        int n = mat.length;
        int m = mat[0].length;

        // Create a visited array to keep track of visited cells
        boolean vis[][] = new boolean[n][m];
        // Create a distance array to store the distance to the nearest 0 for each cell
        int dis[][] = new int[n][m];
        // Initialize a queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Populate the queue with all the 0s in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    // Mark the cell as visited and add it to the queue
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                } else {
                    // Set initial distance to maximum value for cells that are not 0
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions for moving up, down, left, and right
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // Perform BFS to calculate the distance to the nearest 0
        while (!queue.isEmpty()) {
            // Get the current cell from the queue
            int cell[] = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i]; // New row index
                int ncol = col + delcol[i]; // New column index

                // Check if the new position is within bounds and not visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    // Mark the new cell as visited
                    vis[nrow][ncol] = true;
                    // Add the new cell to the queue for further exploration
                    queue.add(new int[]{nrow, ncol});
                    // Update the distance for the new cell
                    dis[nrow][ncol] = dis[row][col] + 1;
                }
            }
        }
        // Return the distance matrix
        return dis;
    }
}
