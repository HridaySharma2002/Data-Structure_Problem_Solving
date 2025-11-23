class Solution {
    public int maxSumDivThree(int[] nums) {
        // dp array to store the maximum sum for each remainder category when divided by 3
        // dp[0] = max sum with remainder 0 (divisible by 3)
        // dp[1] = max sum with remainder 1
        // dp[2] = max sum with remainder 2
        int dp[] = new int[3];
        
        // Initialize dp:
        // dp[0] = 0 because sum of zero elements is 0, which is divisible by 3
        dp[0] = 0;
        // dp[1] and dp[2] initialized to very small values to indicate no valid sums yet
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;
        
        // Iterate over each number in the input array
        for (int num : nums) {
            // Clone the current dp array to avoid overwriting values during iteration
            int curr[] = dp.clone();
            
            // For each remainder category (0, 1, 2), try to add the current number
            for (int i = 0; i < dp.length; i++) {
                // Calculate new remainder after adding num to a sum with remainder i
                int newRemainder = (i + num) % 3;
                
                // Update curr[newRemainder] with the maximum sum possible:
                // Either keep the existing sum or take the sum dp[i] + num
                curr[newRemainder] = Math.max(curr[newRemainder], dp[i] + num);
            }
            
            // Update dp to the new state after considering the current number
            dp = curr;
        }
        
        // dp[0] now contains the maximum sum divisible by 3
        return dp[0];
    }
}
