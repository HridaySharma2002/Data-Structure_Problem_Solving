class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // If there is only one day, only one person knows the secret
        if (n == 1) {
            return n;
        }

        // dp[i] represents the number of people who learn the secret on day i
        long[] dp = new long[n + 1];
        long MOD = (long) 1e9 + 7;  // Modulo to prevent overflow

        long share = 0;  // Number of people who can share the secret on day i

        dp[1] = 1;  // On day 1, one person knows the secret

        // Iterate through each day from day 2 to day n
        for (int i = 2; i <= n; i++) {
            // People who learned the secret 'delay' days ago can start sharing today
            if (i - delay > 0) {
                share = (share + dp[i - delay] + MOD) % MOD;
            }

            // People who learned the secret 'forget' days ago forget it today and stop sharing
            if (i - forget > 0) {
                share = (share - dp[i - forget] + MOD) % MOD;
            }

            // Number of people who learn the secret today is the current number of sharers
            dp[i] = share;
        }

        long know = 0;  // Total number of people who still know the secret on day n

        // Sum all people who learned the secret in the last 'forget' days (they haven't forgotten yet)
        for (int i = n - forget + 1; i <= n; i++) {
            know = (know + dp[i]) % MOD;
        }

        // Return the total count modulo 1e9+7 as an integer
        return (int) know;
    }
}
