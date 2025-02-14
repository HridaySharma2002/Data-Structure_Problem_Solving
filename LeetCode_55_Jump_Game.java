class Solution {
    public boolean canJump(int[] nums) {
        // Initialize the maximum index that can be reached
        int maxInd = 0; 
        
        // Iterate through each index in the nums array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reachable index, return false
            if (i > maxInd) {
                return false; // Cannot reach this index
            }
            // Update the maximum index that can be reached from the current index
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        // If we can reach the last index, return true
        return true; // Successfully reached the end
    }
}
