class Solution {
    public int countTrapezoids(int[][] points) {
        // Use modulo 1e9+7 to avoid integer overflow for large answers
        long MOD = (long)1e9 + 7;

        // Map to count how many points exist at each y-coordinate
        Map<Integer, Long> map = new HashMap<>();
        for (int[] p : points) {
            // For each point, increment the count for its y-coordinate
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }

        // List to store the number of horizontal segments (pairs of points) at each y-level
        ArrayList<Long> seg = new ArrayList<>();
        for (long k : map.values()) {
            // Only consider y-levels with at least 2 points (can form a segment)
            if (k >= 2) {
                // Number of ways to choose 2 points from k: C(k,2) = k*(k-1)/2
                seg.add((k * (k - 1) / 2) % MOD);
            }
        }

        // Now, for every pair of y-levels, the number of trapezoids is the product of their segment counts
        // We use a running sum to efficiently compute the sum of all pairwise products
        long sum = 0;
        long result = 0;
        for (long v : seg) {
            // For each segment count v, add v * sum to the result (sum is the total of previous segment counts)
            result = (result + v * sum) % MOD;
            // Update the running sum with the current segment count
            sum = (sum + v) % MOD;
        }

        // Return the final result as an integer
        return (int)result;
    }
}
