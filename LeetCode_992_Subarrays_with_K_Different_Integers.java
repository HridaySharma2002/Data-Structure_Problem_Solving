class Solution {
    // Main method to find the number of subarrays with exactly k distinct integers
    public int subarraysWithKDistinct(int[] nums, int k) {
        // The number of subarrays with exactly k distinct integers is the difference
        // between the number of subarrays with at most k distinct integers and
        // the number of subarrays with at most k-1 distinct integers.
        return SubArrays(nums, k) - SubArrays(nums, k - 1);
    }

    // Helper method to count the number of subarrays with at most k distinct integers
    public int SubArrays(int[] nums, int k) {
        int count = 0; // Count of valid subarrays
        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to store the frequency of elements

        // Iterate through the array using the right pointer
        while (right < nums.length) {
            // Add the current element to the map and update its frequency
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // If the number of distinct integers in the map exceeds k,
            // shrink the window from the left side until the number of distinct integers is less than or equal to k
            while (map.size() > k) {
                // Decrease the frequency of the leftmost element
                map.put(nums[left], map.get(nums[left]) - 1);
                // If the frequency becomes zero, remove it from the map
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++; // Move the left pointer to the right
            }

            // Count the number of valid subarrays ending at the current right pointer
            // All subarrays from left to right are valid since they contain at most k distinct integers
            count += (right - left + 1);
            right++; // Move the right pointer to the right to expand the window
        }

        // Return the count of subarrays with at most k distinct integers
        return count;
    }
}
