class Solution {
    public int minDeletionSize(String[] strs) {
        // dp[i] will store the length of the longest non-decreasing subsequence ending at column i
        int dp[] = new int[strs[0].length()];
        Arrays.fill(dp, 1); // Initialize all values to 1, as each column alone is a valid subsequence

        // Iterate over each column starting from the second one
        for (int i = 1; i < strs[0].length(); i++) {
            // For each previous column j before i
            for (int j = 0; j < i; j++) {
                // Check if appending column i after column j keeps all rows non-decreasing
                if (isValid(strs, i, j)) {
                    // Update dp[i] if a longer subsequence ending at i is found
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the length of the longest valid subsequence
        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }

        // The answer is the total columns minus the length of the longest valid subsequence
        return strs[0].length() - max;
    }

    // Helper method to check if columns j and i are non-decreasing for all rows
    private boolean isValid(String[] strs, int i, int j) {
        for (String str : strs) {
            // If any row has a decreasing order between columns j and i, return false
            if (str.charAt(j) > str.charAt(i)) {
                return false;
            }
        }
        // All rows are non-decreasing between columns j and i
        return true;
    }
}
