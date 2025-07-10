class Solution {
    public int maximumDifference(int[] nums) {
        // Initialize max_diff to -1, which will hold the maximum difference found
        int max_diff = -1;
        // Start with the first element as the minimum
        int min = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is greater than the minimum found so far
            if (nums[i] > min) {
                // Update max_diff if the difference is greater than the current max_diff
                max_diff = Math.max(max_diff, nums[i] - min);
            }
            // If the current element is less than the minimum, update the minimum
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        // Return the maximum difference found, or -1 if no valid difference exists
        return max_diff;
    }
}
