class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        
        // dp[i] will store the minimum coins needed to get all fruits starting from fruit i
        // We use n+1 size so dp[n] can represent the base case (beyond last fruit)
        int dp[] = new int[n + 1];
        
        // Base case: no coins needed if we are beyond the last fruit
        dp[n] = 0;
        
        // Fill dp array from right to left (starting from last fruit towards the first)
        for (int i = n - 1; i >= 0; i--) {
            // Initialize result to max value to find minimum later
            int result = Integer.MAX_VALUE;
            
            // When buying fruit i, you get next i fruits for free
            // So the next fruit you need to buy is at least i+1
            // The maximum next fruit you might buy is 2*i + 2 (due to free fruits)
            // Also ensure j does not go beyond n (array boundary)
            for (int j = i + 1; j <= 2 * i + 2 && j <= n; j++) {
                // If dp[j] is not max value, it means there's a valid way to get fruits from j onwards
                if (dp[j] != Integer.MAX_VALUE) {
                    // Choose the minimum coins needed among all possible next fruits to buy
                    result = Math.min(result, dp[j]);
                }
            }
            
            // If no valid next fruit found, dp[i] remains Integer.MAX_VALUE (no solution)
            // Otherwise, add the cost of buying current fruit i to the minimum result found
            dp[i] = (result == Integer.MAX_VALUE) ? Integer.MAX_VALUE : result + prices[i];
        }
        
        // dp[0] contains the minimum coins needed to get all fruits starting from the first fruit
        return dp[0];
    }
}
