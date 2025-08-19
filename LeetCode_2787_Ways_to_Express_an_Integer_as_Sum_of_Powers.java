class Solution {
    // Define a constant for modulo operation to prevent integer overflow
    private static final int MOD = 1_000_000_007;

    // Main method to calculate the number of ways to express n as the sum of unique natural numbers raised to the power x
    public int numberOfWays(int n, int x) {
        // dp[sum] will store the number of ways to get 'sum' using unique powers
        long[] dp = new long[n + 1];
        dp[0] = 1; // There is one way to make sum 0: use no numbers

        // Try every natural number i such that i^x <= n
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int power = (int) Math.pow(i, x); // Calculate i^x

            // Update dp array from high to low to ensure each power is only used once
            for (int sum = n; sum >= power; sum--) {
                // Add the number of ways to form (sum - power) to the current sum
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
        }
        // Return the number of ways to form n, modulo MOD
        return (int) dp[n];
    }
}
