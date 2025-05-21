class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // Get the number of rows (n) and columns (m) in the moveTime grid
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Initialize a distance array to store the minimum time to reach each room
        int dist[][] = new int[n][m];
        // Fill the distance array with maximum values initially (representing infinity)
        for (int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Create a priority queue to facilitate Dijkstra's algorithm
        // The priority queue will store arrays of the form {distance, row, column}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Offer the starting position (0,0) with initial distance 0
        pq.offer(new int[]{0, 0, 0});

        // Directions array for moving right, down, left, and up
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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
            if (d > dist[i][j]) {
                continue;
            }

            // Explore all four possible directions from the current room
            for (int dir[] : dirs) {
                int row = i + dir[0]; // New row index
                int col = j + dir[1]; // New column index

                // Check if the new position is within bounds
                if (row >= 0 && row < n && col >= 0 && col < m) {
                    // Calculate the time to reach the new room
                    // The time is the maximum of the room's moveTime and the current time, plus the movement time
                    int time = Math.max(moveTime[row][col], d) + ((i + j) % 2 + 1);
                    // If the new time is less than the recorded time, update and add to the queue
                    if (dist[row][col] > time) {
                        dist[row][col] = time; // Update the distance
                        pq.offer(new int[]{time, row, col}); // Add new room to the queue
                    }
                }
            }
        }

        // Return the minimum time to reach the last room
        return dist[n - 1][m - 1];
    }
}
