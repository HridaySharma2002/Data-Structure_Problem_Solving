class Solution {
    // Inner class to represent the state of transactions at any point
    class State {
        long maxprofit;  // Maximum profit after completing transactions
        long buyhold;    // Maximum profit if currently holding a stock (bought)
        long sellhold;   // Maximum profit if currently holding a short position (sold first)

        // Constructor to initialize the state variables
        State(long profit, long buy, long sell) {
            maxprofit = profit;
            buyhold = buy;
            sellhold = sell;
        }
    }

    public long maximumProfit(int[] prices, int k) {
        int firstprice = prices[0];  // Price on the first day

        // dp array where dp[i] holds the State for i transactions completed
        State[] dp = new State[k + 1];

        // Initialize dp states for all transaction counts from 0 to k
        for (int i = 0; i <= k; i++) {
            // Initially:
            // maxprofit = 0 (no profit yet)
            // buyhold = -firstprice (if we buy on day 0, profit is negative price)
            // sellhold = firstprice (if we short sell on day 0, profit is price)
            dp[i] = new State(0, -firstprice, firstprice);
        }

        // Iterate over each day starting from day 1
        for (int day = 1; day < prices.length; day++) {
            int currprice = prices[day];  // Current day's stock price

            // Iterate over transactions in reverse order to avoid overwriting dp states prematurely
            for (int trans = k; trans > 0; trans--) {
                long prevprofit = dp[trans - 1].maxprofit;  // Profit after one less transaction

                // Update maxprofit for current transaction count:
                // 1) Keep previous maxprofit (do nothing)
                // 2) Sell stock currently held (buyhold + currprice)
                // 3) Buy back stock from short position (sellhold - currprice)
                dp[trans].maxprofit = Math.max(
                    dp[trans].maxprofit,
                    Math.max(dp[trans].buyhold + currprice, dp[trans].sellhold - currprice)
                );

                // Update buyhold:
                // 1) Keep holding the stock (do nothing)
                // 2) Buy stock now, starting a new normal transaction (prevprofit - currprice)
                dp[trans].buyhold = Math.max(dp[trans].buyhold, prevprofit - currprice);

                // Update sellhold:
                // 1) Keep holding the short position (do nothing)
                // 2) Short sell stock now, starting a new short transaction (prevprofit + currprice)
                dp[trans].sellhold = Math.max(dp[trans].sellhold, prevprofit + currprice);
            }
        }

        // Return the maximum profit achievable with at most k transactions
        return dp[k].maxprofit;
    }
}
