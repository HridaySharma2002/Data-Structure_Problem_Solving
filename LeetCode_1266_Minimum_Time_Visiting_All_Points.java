class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0; // Initialize total time to 0

        // Iterate through each consecutive pair of points
        for (int i = 1; i < points.length; i++) {
            // Calculate the absolute difference in x and y coordinates
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);

            // The minimum time to move from one point to the next is the maximum of dx and dy
            // because you can move diagonally (covering both axes in one second)
            result += Math.max(dx, dy);
        }

        // Return the total minimum time to visit all points
        return result;
    }
}
