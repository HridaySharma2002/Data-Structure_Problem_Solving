class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Create a list to hold the resulting intervals
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Step 1: Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]); // Add the current interval to the result
            i++; // Move to the next interval
        }

        // Step 2: Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // Update the new interval's start and end times
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // Update start time
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // Update end time
            i++; // Move to the next interval
        }

        // Add the merged interval to the result
        result.add(newInterval);

        // Step 3: Add all remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]); // Add the current interval to the result
            i++; // Move to the next interval
        }

        // Convert the result list to a 2D array and return it
        return result.toArray(new int[result.size()][]);
    }
}
