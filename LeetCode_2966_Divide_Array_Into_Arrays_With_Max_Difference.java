class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // Sort the input array to facilitate grouping elements with minimal differences
        Arrays.sort(nums);
        int n = nums.length; // Get the length of the array
        
        // Initialize the result array with n/3 rows and 3 columns
        int[][] result = new int[n / 3][3];
        
        // Iterate through the sorted array in steps of 3
        for (int i = 0, j = 0; i < n; i += 3, j++) {
            // Check if the difference between the maximum and minimum in the group exceeds k
            if (nums[i + 2] - nums[i] > k) {
                // If the condition is violated, return an empty array
                return new int[0][0];
            }
            // Store the current group of 3 elements in the result array
            result[j] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        
        // Return the filled result array
        return result;
    }
}
