class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length; // Length of first array
        int m = nums2.length; // Length of second array

        // Create a DP table where dp[i][j] represents the max dot product
        // for the first i elements of nums1 and first j elements of nums2
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the DP table with a very small number (effectively -infinity)
        // This is because we want to ensure that we always take at least one pair
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = (int) -1e9;
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Option 1: Take the current pair (nums1[i-1], nums2[j-1])
                // and add the best result from previous subproblems
                // Math.max(0, dp[i-1][j-1]) ensures we can start a new subsequence here
                int take = nums1[i - 1] * nums2[j - 1] + Math.max(0, dp[i - 1][j - 1]);

                // Option 2: Skip the current element from nums1 or nums2
                // Take the best of skipping either
                dp[i][j] = Math.max(take, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        // The answer is the best dot product using all elements
        return dp[n][m];
    }
}
