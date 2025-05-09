class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0; // Initialize count of valid subarrays
        long sum = 0;   // Initialize sum of the current subarray
        int left = 0;   // Left pointer for the sliding window

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Add the current element to the sum

            // Check if the score of the current subarray is >= k
            while (left <= right && (sum * (right - left + 1)) >= k) {
                sum -= nums[left]; // Remove the leftmost element from the sum
                left++;            // Move the left pointer to the right
            }

            // All subarrays ending at 'right' and starting from 'left' to 'right' are valid
            count += (right - left + 1); // Count the number of valid subarrays
        }

        return count; // Return the total count of valid subarrays
    }
}
