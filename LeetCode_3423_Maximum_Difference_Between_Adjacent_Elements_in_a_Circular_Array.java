class Solution {
    // Method to find the maximum absolute distance between adjacent elements in the array
    public int maxAdjacentDistance(int[] nums) {
        int max_abs = 0; // Variable to store the maximum absolute difference

        // Loop through the array to find the maximum difference between adjacent elements
        for (int i = 0; i < nums.length - 1; i++) {
            max_abs = Math.max(max_abs, Math.abs(nums[i] - nums[i + 1])); // Update max_abs if a larger difference is found
        }

        // Check the absolute difference between the first and last elements
        if (max_abs < Math.abs(nums[0] - nums[nums.length - 1])) {
            max_abs = Math.abs(nums[0] - nums[nums.length - 1]); // Update max_abs if this difference is larger
        }

        return max_abs; // Return the maximum absolute distance found
    }
}
