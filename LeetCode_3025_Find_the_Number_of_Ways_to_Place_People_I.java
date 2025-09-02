class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort the points array with a custom comparator:
        // - First by x-coordinate in ascending order
        // - If x is the same, then by y-coordinate in descending order
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) 
                return Integer.compare(b[1], a[1]); // Descending order for y if x is equal
            return Integer.compare(a[0], b[0]);     // Ascending order for x otherwise
        });

        int n = points.length;  // Number of points
        int result = 0;         // To store the count of valid pairs

        // Iterate over each point as the "top" point in the pair
        for (int i = 0; i < n; i++) {
            int top = points[i][1];               // y-coordinate of the current point
            int bottom = Integer.MIN_VALUE;       // Initialize bottom boundary to smallest integer

            // Check points after i to find valid pairs
            for (int j = i + 1; j < n; j++) {
                int y = points[j][1];             // y-coordinate of the candidate pair point

                // Condition to count a pair:
                // y must be strictly greater than bottom and less than or equal to top
                if (bottom < y && y <= top) {
                    bottom = y;                   // Update bottom to current y to ensure increasing order
                    result++;                     // Increment count of valid pairs

                    // If bottom equals top, no further points can satisfy the condition, so break early
                    if (bottom == top) {
                        break;
                    }
                }
            }
        }

        return result;  // Return the total number of valid pairs found
    }
}
