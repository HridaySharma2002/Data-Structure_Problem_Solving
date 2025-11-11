class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] will store the maximum number of strings that can be formed 
        // with at most i zeros and j ones
        int dp[][] = new int[m+1][n+1];

        // Iterate over each string in the input array
        for (String str : strs) {
            int zeroes = 0;
            int ones = 0;

            // Count the number of zeros and ones in the current string
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }

            // Update the dp array in reverse order to avoid counting the same string multiple times
            // i goes from m down to zeroes because we need enough zeros capacity to include this string
            for (int i = m; i >= zeroes; i--) {
                // j goes from n down to ones for the same reason with ones capacity
                for (int j = n; j >= ones; j--) {
                    // Either skip the current string (dp[i][j]) or include it (dp[i-zeroes][j-ones] + 1)
                    // Take the maximum of these two choices
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }

        // dp[m][n] now contains the size of the largest subset with at most m zeros and n ones
        return dp[m][n];
    }
}
