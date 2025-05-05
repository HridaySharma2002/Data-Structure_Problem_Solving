class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0; // To store the total count of valid subarrays
        int n = nums.length; // Length of the input array
        int left = 0; // Left boundary of the current valid subarray
        int minPos = -1; // Last position of minK
        int maxPos = -1; // Last position of maxK

        // Iterate through the array with a right pointer
        for (int right = 0; right < n; right++) {
            // If the current number is out of bounds, reset the left boundary
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1; // Move left boundary to the next position
                minPos = -1; // Reset last position of minK
                maxPos = -1; // Reset last position of maxK
            }

            // Update the last position of minK if found
            if (nums[right] == minK) {
                minPos = right; // Store the index of minK
            }

            // Update the last position of maxK if found
            if (nums[right] == maxK) {
                maxPos = right; // Store the index of maxK
            }

            // If both minK and maxK have been seen, count the valid subarrays
            if (minPos != -1 && maxPos != -1) {
                // Count the number of valid subarrays ending at 'right'
                count += Math.min(minPos, maxPos) - left + 1;
            }
        }
        return count; // Return the total count of valid subarrays
    }
}
