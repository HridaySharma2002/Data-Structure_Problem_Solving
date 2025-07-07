class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        // Get the number of rows and columns in the input box
        int rows = boxGrid.length; // Number of rows in the original box
        int cols = boxGrid[0].length; // Number of columns in the original box

        // Create a new 2D array to hold the rotated box
        char[][] res = new char[cols][rows]; // Resultant array for the rotated box

        // Initialize the result array with '.' to represent empty spaces
        for (char[] row : res) {
            Arrays.fill(row, '.'); // Fill each row with empty spaces
        }

        // Iterate through each row of the original box
        for (int r = 0; r < rows; r++) {
            int i = cols - 1; // Start filling from the rightmost column of the result
            // Iterate through each column from right to left
            for (int c = cols - 1; c >= 0; c--) {
                // If the current cell is a stone
                if (boxGrid[r][c] == '#') {
                    // Place the stone in the result at the correct position
                    res[i][rows - r - 1] = '#'; // Adjust the position for rotation
                    i--; // Move to the next column to the left for the next stone
                } 
                // If the current cell is an obstacle
                else if (boxGrid[r][c] == '*') {
                    // Place the obstacle in the result at the correct position
                    res[c][rows - r - 1] = '*'; // Adjust the position for rotation
                    i = c - 1; // Reset the position to the left of the obstacle
                }
            }
        }

        // Return the rotated box
        return res; // The final rotated box with stones and obstacles placed correctly
    }
}
