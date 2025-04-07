class Solution {
    // Main function to perform flood fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Store the original color of the starting pixel
        int inicolor = image[sr][sc];
        // Resulting image is initially the same as the input image
        int result[][] = image;
        // Directions for moving up, right, down, and left
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        // Start the depth-first search (DFS) from the starting pixel
        dfs(sr, sc, delrow, delcol, image, result, color, inicolor);
        return result; // Return the modified image
    }

    // Depth-first search function to fill the color
    public void dfs(int row, int col, int delrow[], int delcol[], int[][] image, int[][] result, int color, int inicolor) {
        // Change the color of the current pixel
        result[row][col] = color;
        int n = image.length; // Number of rows in the image
        int m = image[0].length; // Number of columns in the image
        
        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            // Calculate the new row and column indices
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check if the new position is within bounds and has the original color
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == inicolor && result[nrow][ncol] != color) {
                // Recursively call dfs for the new position
                dfs(nrow, ncol, delrow, delcol, image, result, color, inicolor);
            }
        }
    }
}
