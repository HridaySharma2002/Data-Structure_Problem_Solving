class Solution {
    public int numTilings(int n) {
        // Define the modulo constant to prevent overflow
        final int MOD = 1_000_000_007;

        // Base cases for small values of n
        if (n <= 1) {
            return 1; // Only one way to tile a 2x1 board
        }
        if (n == 2) {
            return 2; // Two ways to tile a 2x2 board
        }
        if (n == 3) {
            return 5; // Five ways to tile a 2x3 board
        }

        // Create a dynamic programming array to store the number of ways to tile
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to tile a 2x0 board (do nothing)
        dp[1] = 1; // Base case: 1 way to tile a 2x1 board
        dp[2] = 2; // Base case: 2 ways to tile a 2x2 board
        dp[3] = 5; // Base case: 5 ways to tile a 2x3 board

        // Fill the dp array for all values from 4 to n
        for (int i = 4; i <= n; i++) {
            // The recurrence relation:
            // dp[i] = 2 * dp[i-1] + dp[i-3]
            // - 2 * dp[i-1]: placing a vertical domino at the end
            // - dp[i-3]: placing a tromino at the end
            dp[i] = (int) ((2L * dp[i - 1] + dp[i - 3]) % MOD);
        }

        // Return the number of ways to tile a 2 x n board
        return dp[n];
    }
}
