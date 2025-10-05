class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;       // Number of rows
        int n = heights[0].length;    // Number of columns

        // Boolean matrices to mark cells reachable from Pacific and Atlantic oceans
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        // Run DFS from all cells adjacent to the Pacific Ocean (top row and left column)
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);  // Left column
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);  // Top row
        }

        // Run DFS from all cells adjacent to the Atlantic Ocean (bottom row and right column)
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);  // Right column
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);  // Bottom row
        }

        // Collect cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If cell is reachable from both Pacific and Atlantic, add to result
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    // DFS helper function to mark reachable cells from a given ocean
    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (visited[i][j]) {
            return;  // Already visited this cell, no need to explore again
        }
        visited[i][j] = true;  // Mark current cell as visited

        int m = heights.length;
        int n = heights[0].length;

        // Directions array to explore neighbors: down, up, right, left
        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int d[] : directions) {
            int x = i + d[0];
            int y = j + d[1];

            // Skip if neighbor is out of grid bounds
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }

            // Only move to neighbor if its height is >= current cell's height
            // This simulates water flowing from higher or equal height to lower or equal height
            if (heights[x][y] < heights[i][j]) {
                continue;
            }

            // Recursively DFS from the neighbor cell
            dfs(x, y, heights, visited);
        }
    }
}
