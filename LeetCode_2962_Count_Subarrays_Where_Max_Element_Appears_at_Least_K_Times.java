class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0; // Initialize the count of valid subarrays
        int n = nums.length; // Get the length of the input array
        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        int max_count = 0; // Count of the maximum element in the current window
        int maximum_element = -1; // Variable to store the current maximum element

        // Find the overall maximum element in the array
        for (int ele : nums) {
            if (ele > maximum_element) {
                maximum_element = ele; // Update maximum element
            }
        }

        // Use a sliding window approach to count valid subarrays
        while (right < n) {
            // If the current element is the maximum element, increment its count
            if (nums[right] == maximum_element) {
                max_count++;
            }

            // While the count of the maximum element is at least k
            while (max_count >= k) {
                // Count all subarrays from left to right
                count += (n - right); // Add the number of valid subarrays ending at 'right'

                // If the left pointer points to the maximum element, decrement its count
                if (nums[left] == maximum_element) {
                    max_count--;
                }
                left++; // Move the left pointer to the right
            }
            right++; // Move the right pointer to the right
        }
        return count; // Return the total count of valid subarrays
    }
}
