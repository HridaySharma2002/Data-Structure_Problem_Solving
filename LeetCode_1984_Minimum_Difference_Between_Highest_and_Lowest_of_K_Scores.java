class Solution {
    public int minimumDifference(int[] nums, int k) {
        // If k is 1, the minimum difference between any single element is always 0
        if (k == 1) {
            return 0;
        }
        
        // Sort the array to bring elements closer in value next to each other
        Arrays.sort(nums);
        
        // Initialize mindiff to the largest possible integer value
        // This will store the minimum difference found
        int mindiff = Integer.MAX_VALUE;
        
        // Iterate through the array, considering every subarray of length k
        // The loop runs until the last possible subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {
            // Calculate the difference between the max and min in this subarray
            // Since the array is sorted, nums[i+k-1] is the max and nums[i] is the min
            int diff = nums[i + k - 1] - nums[i];
            
            // Update mindiff if the current difference is smaller
            mindiff = Math.min(mindiff, diff);
        }
        
        // Return the smallest difference found among all subarrays of size k
        return mindiff;
    }
}
