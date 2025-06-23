class Solution {
    public int snakesAndLadders(int[][] board) {
        // Get the size of the board (n x n)
        int n = board.length;
        // Calculate the target square number (n^2)
        int target = n * n;
        // Create a visited array to track which squares have been visited
        boolean vis[] = new boolean[target + 1];
        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Start from square 1
        queue.offer(1);
        // Mark square 1 as visited
        vis[1] = true;
        // Initialize the move counter
        int moves = 0;

        // Perform BFS until there are no more squares to process
        while (!queue.isEmpty()) {
            // Get the number of squares to process at the current level
            int size = queue.size();
            // Process each square in the current level
            for (int i = 0; i < size; i++) {
                // Get the current square being processed
                int curr = queue.poll();
                // Check if we have reached the target square
                if (curr == target) {
                    return moves; // Return the number of moves taken to reach the target
                }

                // Try all possible dice rolls from 1 to 6
                for (int dice = 1; dice <= 6; dice++) {
                    // Calculate the next square based on the current square and dice roll
                    int next = curr + dice;
                    // If the next square exceeds the target, ignore it
                    if (next > target) {
                        continue;
                    }

                    // Get the board position (row and column) for the next square
                    int[] pos = boardpositions(next, n);
                    int r = pos[0]; // Row index
                    int c = pos[1]; // Column index

                    // Check if the square has a snake or ladder
                    if (board[r][c] != -1) {
                        // Move to the destination of the snake or ladder
                        next = board[r][c];
                    }

                    // If the next square hasn't been visited, add it to the queue
                    if (!vis[next]) {
                        vis[next] = true; // Mark the next square as visited
                        queue.offer(next); // Add the next square to the queue for processing
                    }
                }
            }
            // Increment the number of moves after processing all squares at the current level
            moves++;
        }
        // If we cannot reach the last square, return -1
        return -1;
    }

    // Helper method to convert a linear square number to board coordinates
    private int[] boardpositions(int num, int n) {
        // Calculate the row index based on the square number
        int row = (num - 1) / n;
        // Calculate the column index based on the square number
        int col = (num - 1) % n;
        // Adjust for the Boustrophedon style (reverse column for odd rows)
        if (row % 2 == 1) {
            col = n - 1 - col; // Reverse the column for odd rows
        }
        // Return the adjusted row and column coordinates
        return new int[]{n - 1 - row, col}; // Return the coordinates in the format [row, col]
    }
}
