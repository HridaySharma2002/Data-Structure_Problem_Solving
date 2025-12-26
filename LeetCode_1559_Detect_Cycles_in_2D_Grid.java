class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;       // Number of rows in the grid
        int m = grid[0].length;    // Number of columns in the grid
        boolean visited[][] = new boolean[n][m];  // To keep track of visited cells during DFS

        // Iterate over every cell in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // If the cell is not visited, start DFS from here
                // If DFS finds a cycle, return true immediately
                if (!visited[row][col] && dfs(row, col, -1, -1, grid, visited, grid[row][col])) {
                    return true;
                }
            }
        }
        // If no cycle found after exploring all cells, return false
        return false;
    }
    private boolean dfs(int row, int col, int pr, int pc, char[][] grid, boolean visited[][], char ch) {
        // If this cell is already visited, a cycle is detected
        if (visited[row][col]) {
            return true;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        int n = grid.length;       // Number of rows
        int m = grid[0].length;    // Number of columns

        // Directions array to explore up, down, left, and right neighbors
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Explore all four directions
        for (int dir[] : directions) {
            int nrow = row + dir[0];  // New row index
            int ncol = col + dir[1];  // New column index

            // Check if new position is within grid boundaries and has the same character
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == ch) {
                // Skip the cell we came from to avoid trivial immediate backtracking
                if (nrow == pr && ncol == pc) {
                    continue;
                }
                // Recursively DFS on the neighbor cell
                if (dfs(nrow, ncol, row, col, grid, visited, ch)) {
                    return true;  // Cycle detected in recursion
                }
            }
        }

        // No cycle found from this path
        return false;
    }
}
