class Solution {
    public long maxPower(int[] stations, int r, int k) {
        // Initialize the binary search range:
        // 'left' is the minimum number of stations at any city (lower bound for min power)
        long left = Arrays.stream(stations).min().getAsInt();
        // 'right' is the sum of all stations plus k (all new stations in one city) + 1 (exclusive upper bound)
        long right = Arrays.stream(stations).asLongStream().sum() + k + 1;

        // Binary search to find the highest minimum power possible
        while (left < right) {
            // Calculate the mid value (candidate for minimum power)
            long mid = left + (right - left) / 2;
            // Check if it's possible to achieve at least 'mid' power for every city
            if (check(stations.clone(), r, k, mid)) {
                // If possible, try for a higher minimum
                left = mid + 1;
            } else {
                // Otherwise, try for a lower minimum
                right = mid;
            }
        }
        // After binary search, left is one more than the answer
        return left - 1;
    }

    // Helper function to check if every city can have at least 'minPower'
    private boolean check(int[] stations, int r, int additionalStations, long minPower) {
        int n = stations.length;
        long power = 0; // Current window sum of power

        // Initialize power for the first city (sum of stations in range [0, r-1])
        for (int i = 0; i < r; i++) {
            power += stations[i];
        }

        // Slide the window across all cities
        for (int i = 0; i < n; i++) {
            // Add the rightmost new city in the window if within bounds
            if (i + r < n) {
                power += stations[i + r];
            }
            // If current city has less than minPower, add stations
            if (power < minPower) {
                long requiredPower = minPower - power;
                // Not enough stations left to add
                if (requiredPower > additionalStations) {
                    return false;
                }
                // Add requiredPower stations at the farthest right in the window
                stations[Math.min(n - 1, i + r)] += requiredPower;
                additionalStations -= requiredPower;
                power += requiredPower;
            }
            // Remove the leftmost city from the window as we slide right
            if (i - r >= 0) {
                power -= stations[i - r];
            }
        }
        // All cities have at least minPower
        return true;
    }
}
