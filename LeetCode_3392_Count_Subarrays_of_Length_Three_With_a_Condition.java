class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0; // Initialize a counter for valid subarrays
        int n = nums.length; // Get the length of the input array

        // Iterate through the array, stopping at n-2 to avoid out-of-bounds
        for (int i = 0; i < n - 2; i++) {
            // Check the condition for the subarray nums[i], nums[i+1], nums[i+2]
            // The condition checks if the sum of the first and third elements equals half of the second element
            if (2 * (nums[i] + nums[i + 2]) == nums[i + 1]) {
                count++; // Increment the count if the condition is met
            }
        }

        return count; // Return the total count of valid subarrays
    }
}
