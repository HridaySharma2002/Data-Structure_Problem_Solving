class Solution {
    // Main method to find the number of subarrays with exactly k odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        // The number of subarrays with exactly k odd numbers is the difference
        // between the number of subarrays with at most k odd numbers and
        // the number of subarrays with at most k-1 odd numbers.
        return SubArrays(nums, k) - SubArrays(nums, k - 1);
    }

    // Helper method to count the number of subarrays with at most k odd numbers
    public int SubArrays(int[] nums, int k) {
        // If k is negative, there can't be any valid subarrays
        if (k < 0) {
            return 0;
        }
        
        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        int sum = 0; // Current count of odd numbers in the window
        int count = 0; // Count of valid subarrays

        // Iterate through the array using the right pointer
        while (right < nums.length) {
            // Increment the sum by 1 if the current number is odd
            sum += (nums[right] % 2);
            
            // If the count of odd numbers exceeds k, move the left pointer to reduce the count
            while (sum > k) {
                sum -= (nums[left] % 2);
                left++;
            }
            
            // Count the number of valid subarrays ending at the current right pointer
            // All subarrays from left to right are valid since they contain at most k odd numbers
            count += (right - left + 1);
            // Move the right pointer to the right to expand the window
            right++;
        }
        
        // Return the count of subarrays with at most k odd numbers
        return count;
    }
}
