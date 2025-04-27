class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array to use two pointers for efficient pair counting
        Arrays.sort(nums);
        long count = 0; // Initialize the count of fair pairs
        int n = nums.length; // Get the length of the array

        // Iterate through each element in the sorted array
        for (int i = 0; i < n; i++) {
            // Calculate the lower and upper bounds for the current number
            int left = findLowerBound(nums, i + 1, n, lower - nums[i]);
            int right = findUpperBound(nums, i + 1, n, upper - nums[i]);
            // Add the number of valid pairs found in the range to the count
            count += right - left;
        }
        return count; // Return the total count of fair pairs
    }

    // Helper method to find the lower bound index using binary search
    private int findLowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2; // Calculate the mid index
            // If the mid element is less than the target, move the start pointer
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // Otherwise, move the end pointer
                end = mid;
            }
        }
        return start; // Return the index of the lower bound
    }

    // Helper method to find the upper bound index using binary search
    private int findUpperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2; // Calculate the mid index
            // If the mid element is less than or equal to the target, move the start pointer
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                // Otherwise, move the end pointer
                end = mid;
            }
        }
        return start; // Return the index of the upper bound
    }
}
