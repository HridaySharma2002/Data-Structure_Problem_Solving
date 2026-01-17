class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // Variable to keep track of the maximum side length of the square found so far
        long maxSide = 0;
        // Number of rectangles given
        int n = bottomLeft.length;

        // Iterate over all pairs of rectangles to find their intersection
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the boundaries of the intersection rectangle between rectangles i and j
                // For the bottom-left corner of the intersection, take the maximum x and y coordinates
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                // For the top-right corner of the intersection, take the minimum x and y coordinates
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);

                // Calculate the width and height of the intersection rectangle
                long width = x2 - x1;
                long height = y2 - y1;

                // Check if the intersection is valid (both width and height must be positive)
                if (width > 0 && height > 0) {
                    // The largest square side that can fit inside the intersection is the smaller of width and height
                    long side = Math.min(width, height);
                    // Update maxSide if this square is larger than the previously found ones
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        // Return the area of the largest square found (side squared)
        return maxSide * maxSide;
    }
}
