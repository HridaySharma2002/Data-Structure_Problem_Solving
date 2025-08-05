class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        // Boolean array to keep track of which numbers are currently in the window (subarray)
        boolean check[] = new boolean[10001]; // Since nums[i] <= 10000 as per problem constraints
        int left = 0; // Left pointer for the sliding window
        int currentsum = 0; // Current sum of the unique subarray
        int maxsum = 0; // Maximum sum found so far

        // Iterate with the right pointer over the array
        for (int right = 0; right < nums.length; right++) {
            // If nums[right] is already in the current window, move left pointer to remove duplicates
            while (check[nums[right]]) {
                currentsum -= nums[left]; // Remove nums[left] from current sum
                check[nums[left]] = false; // Mark nums[left] as not in the window
                left++; // Move left pointer forward
            }
            // Add nums[right] to the current window
            currentsum += nums[right];
            check[nums[right]] = true; // Mark nums[right] as present in the window

            // Update maxsum if the current sum is greater
            if (currentsum > maxsum) {
                maxsum = currentsum;
            }
        }
        // Return the maximum sum of a subarray with all unique elements
        return maxsum;
    }
}
