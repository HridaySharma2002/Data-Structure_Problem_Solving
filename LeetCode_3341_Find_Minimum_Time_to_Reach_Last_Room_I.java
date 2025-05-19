class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // Get the number of rows (n) and columns (m) in the moveTime grid
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Initialize a distance array to store the minimum time to reach each room
        int[][] dis = new int[n][m];
        // Fill the distance array with maximum values initially
        for (int row[] : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Set the starting room (0,0) distance to 0
        dis[0][0] = 0;

        // Create a priority queue to facilitate Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Offer the starting position with initial distance
        pq.offer(new int[]{0, 0, 0}); // {distance, row, column}

        // Directions array for moving up, right, down, and left
        int dirs[] = {-1, 0, 1, 0, -1};

        // While there are rooms to process in the priority queue
        while (!pq.isEmpty()) {
            // Poll the room with the smallest distance
            int p[] = pq.poll();
            int d = p[0]; // Current distance
            int i = p[1]; // Current row
            int j = p[2]; // Current column

            // If we reached the bottom-right room, return the distance
            if (i == n - 1 && j == m - 1) {
                return d;
            }

            // If the current distance is greater than the recorded distance, skip processing
            if (d > dis[i][j]) {
                continue;
            }

            // Explore all four possible directions from the current room
            for (int k = 0; k < 4; k++) {
                int d_row = i + dirs[k]; // New row index
                int d_col = j + dirs[k + 1]; // New column index

                // Check if the new position is within bounds
                if (d_row >= 0 && d_row < n && d_col >= 0 && d_col < m) {
                    // Calculate the time to reach the new room
                    int time = Math.max(moveTime[d_row][d_col], dis[i][j]) + 1;
                    // If the new time is less than the recorded time, update and add to the queue
                    if (dis[d_row][d_col] > time) {
                        dis[d_row][d_col] = time; // Update the distance
                        pq.offer(new int[]{time, d_row, d_col}); // Add new room to the queue
                    }
                }
            }
        }
        // Return the minimum time to reach the last room
        return dis[n - 1][m - 1];
    }
}
