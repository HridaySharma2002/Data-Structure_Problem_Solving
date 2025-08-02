class Solution {
    public int maximumLength(int[] nums, int k) {
        // dp[i][j] stores the length of the longest valid subsequence
        // ending with two numbers whose remainders modulo k are i and j, respectively
        int dp[][] = new int[k][k];
        int max = 0; // To keep track of the maximum length found

        // Iterate through each number in the input array
        for (int num : nums) {
            int currentrem = num % k; // Calculate the remainder of the current number

            // Try to extend all possible previous remainder pairs
            for (int prevrem = 0; prevrem < k; prevrem++) {
                // Update dp[prevrem][currentrem] by extending the subsequence
                // that previously ended with (currentrem, prevrem)
                dp[prevrem][currentrem] = dp[currentrem][prevrem] + 1;

                // Update the maximum length if this subsequence is longer
                max = Math.max(max, dp[prevrem][currentrem]);
            }
        }
        
        // Return the length of the longest valid subsequence found
        return max;
    }
}
