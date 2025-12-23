class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end time (ascending)
        // This allows us to efficiently find non-overlapping events using binary search
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] endt = new int[n];  // endt[i] will store the end time of the i-th event after sorting
        int[] best = new int[n];  // best[i] will store the maximum value among events[0..i]

        // Step 2: Fill endt[] and best[] arrays
        for (int i = 0; i < n; i++) {
            endt[i] = events[i][1];      // Store end time
            best[i] = events[i][2];      // Store value
            if (i > 0) {
                // Update best[i] to be the maximum value so far
                best[i] = Math.max(best[i], best[i - 1]);
            }
        }

        int result = 0; // This will hold the maximum sum of values for at most two non-overlapping events

        // Step 3: For each event, try to pair it with the best previous non-overlapping event
        for (int i = 0; i < n; i++) {
            int st = events[i][0];   // Start time of the current event
            int val = events[i][2];  // Value of the current event

            // Binary search for the rightmost event that ends before the current event starts
            int left = 0;
            int right = n - 1;
            int ind = -1; // Index of the best previous non-overlapping event

            while (left <= right) {
                int mid = (left + right) >>> 1; // Same as (left + right) / 2, but faster
                if (endt[mid] < st) {
                    ind = mid;         // Found a non-overlapping event, try to find a later one
                    left = mid + 1;
                } else {
                    right = mid - 1;   // Overlaps, search earlier events
                }
            }

            // If a non-overlapping event was found, consider the sum of their values
            if (ind != -1) {
                result = Math.max(result, val + best[ind]);
            }
            // Also consider just taking the current event alone (in case it's the best)
            result = Math.max(result, val);
        }

        // Step 4: Return the maximum sum found
        return result;
    }
}
