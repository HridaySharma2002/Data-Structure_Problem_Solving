class Solution {
    // Main method to find the number of subarrays with a given sum
    public int numSubarraysWithSum(int[] nums, int goal) {
        // The number of subarrays with sum equal to 'goal' minus the number of subarrays with sum equal to 'goal - 1'
        return SubArrays(nums, goal) - SubArrays(nums, goal - 1);
    }

    // Helper method to count the number of subarrays with a sum equal to 'goal'
    public int SubArrays(int[] nums, int goal) {
        // If the goal is negative, there can't be any valid subarrays
        if (goal < 0) {
            return 0;
        }
        
        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        int sum = 0; // Current sum of the elements in the window
        int count = 0; // Count of valid subarrays

        // Iterate through the array using the right pointer
        while (right < nums.length) {
            // Add the current element to the sum
            sum += nums[right];
            
            // If the current sum exceeds the goal, move the left pointer to reduce the sum
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            
            // Count the number of valid subarrays ending at the current right pointer
            count += (right - left + 1);
            // Move the right pointer to the right to expand the window
            right++;
        }
        
        // Return the count of subarrays with the specified sum
        return count;
    }
}
