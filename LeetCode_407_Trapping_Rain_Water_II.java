class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;          // Number of rows in the height map
        int n = heightMap[0].length;       // Number of columns in the height map
        
        // vol will store the current "water level" at each cell, initialized to the height of the terrain
        int[][] vol = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vol[i][j] = heightMap[i][j];
            }
        }

        boolean upt = true;  // Flag to track if any water level update happened in the last iteration
        boolean init = true; // Flag to indicate the first iteration of the update loop

        // Repeat until no more updates occur (water levels stabilize)
        while (upt) {
            upt = false;

            // Forward pass: update water levels from top-left to bottom-right
            // For each inner cell, water level is max of cell height and min of top and left neighbors' water levels
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(vol[i - 1][j], vol[i][j - 1]));
                    // Update water level if it's the first pass or if we can lower the current water level
                    if (init || vol[i][j] > val) {
                        vol[i][j] = val;
                        upt = true; // Mark that an update happened
                    }
                }
            }
            init = false; // After first pass, set init to false

            // Backward pass: update water levels from bottom-right to top-left
            // For each inner cell, water level is max of cell height and min of bottom and right neighbors' water levels
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(vol[i + 1][j], vol[i][j + 1]));
                    // Update water level if it can be lowered
                    if (vol[i][j] > val) {
                        vol[i][j] = val;
                        upt = true; // Mark that an update happened
                    }
                }
            }
        }

        int res = 0; // Accumulate total trapped water volume

        // Calculate trapped water by summing the difference between water level and terrain height for each inner cell
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vol[i][j] > heightMap[i][j]) {
                    res += vol[i][j] - heightMap[i][j];
                }
            }
        }
        return res; // Return total trapped water
    }
}
