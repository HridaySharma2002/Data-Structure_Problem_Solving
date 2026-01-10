class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        // dp[i][j] will store the maximum ASCII sum of the common subsequence
        // between s1[0..i-1] and s2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Build the dp table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If characters match, add their ASCII value to the result from previous indices
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                else
                    // Otherwise, take the maximum value by either skipping a character from s1 or s2
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        // Calculate the total ASCII sum of both strings
        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;

        // The answer is total sum minus twice the sum of the common subsequence
        // (since those characters are kept, not deleted)
        return total - 2 * dp[n][m];
    }
}
