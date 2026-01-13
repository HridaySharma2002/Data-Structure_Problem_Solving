class Solution {
    public double separateSquares(int[][] squares) {
        // Initialize the binary search range.
        // The lowest possible y is 0, the highest is 2e9 (since max y + l <= 2e9).
        double low = 0;
        double high = 2 * 1e9;

        // Perform binary search for 60 iterations to ensure precision within 1e-5.
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            // Compute the difference between area above and below the line y = mid.
            double diff = seperate(mid, squares);

            // If area above is greater than area below, move the search range up.
            if (diff > 0) {
                low = mid;
            } else {
                // Otherwise, move the search range down.
                high = mid;
            }
        }
        // After binary search, 'high' will be the minimum y where areas are balanced.
        return high;
    }
    private double seperate(double line, int[][] squares) {
        double above = 0;
        double below = 0;

        // Iterate through each square to calculate its contribution.
        for (int i = 0; i < squares.length; i++) {
            int x = squares[i][0];
            int y = squares[i][1];
            int l = squares[i][2];
            double total = (double) l * l; // Total area of the current square

            if (line <= y) {
                // The line is below the square; all area is above the line.
                above += total;
            } else if (line >= y + l) {
                // The line is above the square; all area is below the line.
                below += total;
            } else {
                // The line cuts through the square.
                // Calculate the area above and below the line within this square.
                double aboveheight = (y + l) - line; // Height of the part above the line
                double belowheight = line - y;       // Height of the part below the line
                above += l * aboveheight;
                below += l * belowheight;
            }
        }
        // Return the difference: positive means more area above, negative means more below.
        return above - below;
    }
}
