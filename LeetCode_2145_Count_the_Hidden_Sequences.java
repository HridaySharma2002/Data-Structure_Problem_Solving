class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // Initialize variables to track the minimum and maximum possible values of the hidden sequence
        long min = 0, max = 0, current = 0;

        // Iterate through the differences array to calculate cumulative sums
        for (int diff : differences) {
            current += diff; // Update the current value based on the difference
            min = Math.min(min, current); // Update the minimum value encountered
            max = Math.max(max, current); // Update the maximum value encountered
        }

        // Calculate the valid range for the first element of the hidden sequence
        long range_min = lower - min; // Minimum starting point adjusted by the minimum offset
        long range_max = upper - max; // Maximum starting point adjusted by the maximum offset

        // Calculate the number of valid starting points for the hidden sequence
        // Ensure the result is non-negative
        return (int) Math.max(0, range_max - range_min + 1);
    }
}
