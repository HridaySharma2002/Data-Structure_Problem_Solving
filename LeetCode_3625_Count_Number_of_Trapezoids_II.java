class Solution {
    public int countTrapezoids(int[][] points) {
        // t: Groups segments by normalized slope (sx, sy) for parallelism
        //    Outer key: normalized slope, Inner key: line constant, Value: count of segments
        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
        // v: Groups segments by exact direction vector (dx, dy) for collinearity
        //    Outer key: exact direction, Inner key: line constant, Value: count of segments
        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();
        int n = points.length;
        // Iterate over all pairs of points to form all possible segments
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compute direction vector from point i to point j
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                // Normalize direction: ensure dx is positive (or dy positive if dx==0)
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                // Reduce direction vector to its simplest form using GCD
                int g = gcd(dx, Math.abs(dy));
                int sx = dx / g; // normalized x component (slope)
                int sy = dy / g; // normalized y component (slope)
                // Compute a constant that uniquely identifies the line for this slope
                int des = sx * points[i][1] - sy * points[i][0];
                // Pack normalized slope and direction into unique integer keys for hash maps
                // Offset sy/dy by 2000 to ensure non-negative keys (since coordinates can be negative)
                int key1 = (sx << 12) | (sy + 2000); // key for normalized slope
                int key2 = (dx << 12) | (dy + 2000); // key for exact direction
                // Add this segment to the parallel group (t)
                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                // Add this segment to the collinear group (v)
                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }
        // Use inclusion-exclusion:
        // count(t): number of unordered pairs of parallel segments (potential trapezoid bases)
        // count(v): number of unordered pairs of collinear segments (degenerate, not valid)
        // Divide count(v) by 2 because each collinear pair is counted twice
        return count(t) - count(v) / 2;
    }

    // Counts the number of unordered pairs of segments in all groups of the map
    // For each group (same slope or direction), counts pairs of segments on different lines
    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
        long result = 0;
        for (HashMap<Integer, Integer> inner : map.values()) {
            long sum = 0;
            // sum: total number of segments in this group
            for (int val : inner.values()) {
                sum += val;
            }
            // For each line in the group, count pairs with segments on other lines
            for (int val : inner.values()) {
                sum -= val;
                result += (long) val * sum;
            }
        }
        return (int) result;
    }

    // Computes the greatest common divisor (GCD) of a and b using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}
