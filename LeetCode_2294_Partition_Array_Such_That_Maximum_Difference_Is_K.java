class Solution {
    public int partitionArray(int[] nums, int k) {
        // Sort the array to group nearby values together
        Arrays.sort(nums);
        
        // Initialize the count of subsequences to 1 (at least one subsequence is needed)
        int count = 1;
        
        // Set the first element as the minimum of the first subsequence
        int min = nums[0];
        
        // Iterate through the sorted array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Check if the current number exceeds the allowed difference from the minimum
            if (nums[i] - min > k) {
                // If it does, we need to create a new subsequence
                count++;
                // Update the minimum for the new subsequence to the current number
                min = nums[i];
            }
        }
        
        // Return the total number of subsequences formed
        return count;
    }
}
