class Solution {
    public long countGood(int[] nums, int k) {
        long count = 0; // This will hold the total number of good subarrays
        int n = nums.length; // Length of the input array
        Map<Integer, Integer> freqMap = new HashMap<>(); // Frequency map to count occurrences of each number
        int pairs = 0; // This will count the number of pairs (i, j) such that nums[i] == nums[j]
        int left = 0; // Left pointer for the sliding window

        // Iterate through the array with the right pointer
        for (int right = 0; right < n; right++) {
            int currentNum = nums[right]; // Get the current number at the right pointer
            // Update the frequency of the current number in the map
            freqMap.put(currentNum, freqMap.getOrDefault(currentNum, 0) + 1);
            // Calculate the number of pairs formed with the current number
            pairs += freqMap.get(currentNum) - 1; // Each new occurrence of currentNum adds (f - 1) pairs

            // If the number of pairs is greater than or equal to k, we need to adjust the left pointer
            while (pairs >= k) {
                // Count the number of good subarrays ending at 'right'
                count += n - right; // All subarrays from left to right are valid
                // Decrease the frequency of the number at the left pointer
                int leftNum = nums[left];
                pairs -= freqMap.get(leftNum) - 1; // Update pairs count by removing the leftNum's contribution
                freqMap.put(leftNum, freqMap.get(leftNum) - 1); // Decrease its frequency
                // If the frequency of leftNum drops to zero, remove it from the map
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++; // Move the left pointer to the right to shrink the window
            }
        }
        return count; // Return the total count of good subarrays
    }
}
