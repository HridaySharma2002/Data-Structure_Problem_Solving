class Solution {
    public boolean canPartition(int[] nums) {
        // Step 1: Calculate the total sum of the array elements
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num; // Accumulate the sum of all elements
        }

        // Step 2: Check if the total sum is odd
        // If the total sum is odd, we cannot partition it into two equal subsets
        if (total_sum % 2 != 0) {
            return false; // Return false if the total sum is odd
        }

        // Step 3: Set the target sum as half of the total sum
        int target = total_sum / 2;

        // Step 4: Initialize the DP array
        // dp[j] will be true if a subset with sum j can be formed
        boolean dp[] = new boolean[target + 1];
        dp[0] = true; // A sum of 0 can always be achieved with an empty subset

        // Step 5: Iterate through each number in the array
        for (int num : nums) {
            // Step 6: Update the dp array from right to left
            // This ensures that each number is only used once
            for (int j = target; j >= num; j--) {
                // Update dp[j] to true if we can form the sum j
                dp[j] = dp[j] || dp[j - num]; // Check if we can achieve sum j
            }
        }

        // Step 7: The answer is whether we can achieve the target sum
        return dp[target]; // Return true if a subset with sum equal to target exists
    }
}
