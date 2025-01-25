class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; // Initialize the left pointer for the sliding window
        int right = 0; // Initialize the right pointer for the sliding window
        int max_len = 0; // Variable to store the maximum length of the substring
        int zeroes = 0; // Count of zeroes in the current window

        // Iterate through the array using the right pointer
        while (right < nums.length) {
            // If the current element is zero, increment the zero count
            if (nums[right] == 0) {
                zeroes++;
            }

            // If the count of zeroes exceeds k, move the left pointer to reduce zeroes
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--; // Decrement zero count if the left element is zero
                }
                left++; // Move the left pointer to the right
            }

            // Calculate the length of the current valid window and update max_len
            max_len = Math.max(max_len, right - left + 1);
            right++; // Move the right pointer to the right
        }
        
        return max_len; // Return the maximum length found
    }
}
