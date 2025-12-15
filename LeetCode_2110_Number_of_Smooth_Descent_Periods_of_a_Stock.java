class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 1; // Initialize result with 1, as the first element is always a descent period by itself
        long count = 1;  // Tracks the length of the current descent period

        // Iterate through the prices array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // Check if the current price is exactly 1 less than the previous price
            if (prices[i] == prices[i - 1] - 1) {
                count++; // Extend the current descent period
            } else {
                count = 1; // Reset count as the descent period is broken
            }
            result += count; // Add the current count to the result
        }
        return result; // Return the total number of descent periods
    }
}
