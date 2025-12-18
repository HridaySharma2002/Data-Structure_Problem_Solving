class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        // Initialize the current profit based on the given strategy
        long currentprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            // For each day, add the profit or loss depending on the strategy (0 or 1)
            currentprofit += (long) strategy[i] * prices[i];
        }

        // Calculate half of k, used for window calculations
        int halfk = k / 2;
        long windowgain = 0;

        // Subtract the profit for the first halfk days in the window
        for (int i = 0; i < halfk; i++) {
            windowgain -= (long) strategy[i] * prices[i];
        }

        // For the next halfk days, add the profit if the strategy is changed from 0 to 1
        for (int i = halfk; i < k; i++) {
            windowgain += (long) (1 - strategy[i]) * prices[i];
        }

        // Initialize maxgain to the best gain found so far (at least 0)
        long maxgain = Math.max(0, windowgain);

        // Slide the window across the array to find the maximum possible gain
        for (int i = 0; i < prices.length - k; i++) {
            // Remove the effect of the outgoing element from the window
            windowgain -= (-(long) strategy[i] * prices[i]);
            // Remove the price at the midpoint of the window
            windowgain -= prices[i + halfk];
            // Index of the new element entering the window
            int newind = i + k;
            // Add the effect of the new element if strategy is changed from 0 to 1
            windowgain += (long) (1 - strategy[newind]) * prices[newind];
            // Update maxgain if the current windowgain is higher
            maxgain = Math.max(maxgain, windowgain);
        }

        // Return the sum of the original profit and the maximum gain found
        return maxgain + currentprofit;
    }
}
