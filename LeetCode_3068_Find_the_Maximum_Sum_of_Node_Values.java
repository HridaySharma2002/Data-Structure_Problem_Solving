class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxsum = 0; // Initialize the maximum sum of node values
        int changedcount = 0; // Count of nodes that can be increased by XOR operation
        int minChangediff = Integer.MAX_VALUE; // Minimum difference between original and XORed values

        // Iterate through each node's value
        for (int num : nums) {
            // Calculate the maximum value between the original and the XORed value
            maxsum += Math.max(num, num ^ k);
            // Count how many nodes can be increased by the XOR operation
            changedcount += ((num ^ k) > num) ? 1 : 0;
            // Update the minimum change difference
            minChangediff = Math.min(minChangediff, Math.abs(num - (num ^ k)));
        }

        // If the count of changes is even, return the maximum sum directly
        if (changedcount % 2 == 0) {
            return maxsum;
        }

        // If odd, subtract the minimum change difference from the maximum sum
        return maxsum - minChangediff;
    }
}
