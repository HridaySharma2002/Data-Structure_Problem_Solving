class Solution {
    // This method finds the area of the rectangle with the largest diagonal.
    // If multiple rectangles have the same diagonal, it returns the one with the largest area.
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length; // Number of rectangles in the input array
        int maxarea = 0;           // To store the maximum area found so far
        int maxdiag = 0;           // To store the maximum diagonal squared found so far

        // Iterate through each rectangle's dimensions
        for (int i = 0; i < n; i++) {
            int l = dimensions[i][0]; // Length of the current rectangle
            int w = dimensions[i][1]; // Width of the current rectangle

            // Calculate the square of the diagonal using Pythagoras theorem
            int currdiag = l * l + w * w;

            // Check if this rectangle has a longer diagonal,
            // or if diagonals are equal, check for a larger area
            if (currdiag > maxdiag || (currdiag == maxdiag && l * w > maxarea)) {
                maxdiag = currdiag;   // Update the maximum diagonal squared
                maxarea = l * w;      // Update the maximum area
            }
        }
        // Return the area of the rectangle with the largest diagonal (or largest area if tie)
        return maxarea;
    }
}
