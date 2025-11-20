class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort intervals by their end point in ascending order.
        // If two intervals have the same end, sort by start in descending order.
        // This helps maximize overlap and minimize the number of points needed.
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int result = 0; // This will store the minimum size of the containing set.
        int a = -1;     // The second last point added to the set.
        int b = -1;     // The last point added to the set.

        // Iterate through each interval
        for (int[] it : intervals) {
            int l = it[0]; // Start of the current interval
            int r = it[1]; // End of the current interval

            // If the current interval starts after the last point in the set,
            // it means neither 'a' nor 'b' are in this interval.
            // So, we need to add two new points: r-1 and r.
            if (l > b) {
                a = r - 1;
                b = r;
                result += 2;
            }
            // If the current interval starts after the second last point,
            // but not after the last point, only 'b' is in the interval.
            // So, we need to add one more point: r.
            else if (l > a) {
                a = b;
                b = r;
                result += 1;
            }
            // Else, both 'a' and 'b' are already in the interval,
            // so we don't need to add any new points.
        }
        // Return the minimum size of the containing set
        return result;
    }
}
