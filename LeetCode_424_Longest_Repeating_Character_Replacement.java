class Solution {
    public int characterReplacement(String s, int k) {
        // Initialize pointers for the sliding window
        int left = 0; // Left pointer of the window
        int right = 0; // Right pointer of the window
        int max_freq = 0; // Variable to track the maximum frequency of any character in the current window
        int max_len = 0; // Variable to store the maximum length of the substring found
        int[] hash = new int[26]; // Array to count the frequency of each character (A-Z)

        // Iterate through the string using the right pointer
        while (right < s.length()) {
            // Increment the count for the current character at the right pointer
            hash[s.charAt(right) - 'A']++;
            // Update the maximum frequency of any character in the current window
            max_freq = Math.max(max_freq, hash[s.charAt(right) - 'A']);
            
            // Check if the number of characters that need to be changed exceeds k
            if ((right - left + 1) - max_freq > k) {
                // If it does, decrement the count for the character at the left pointer
                hash[s.charAt(left) - 'A']--;
                // Move the left pointer to the right to shrink the window
                left++;
            }
            
            // Update the maximum length of the substring found
            max_len = Math.max(max_len, right - left + 1);
            // Move the right pointer to the right to expand the window
            right++;
        }
        
        // Return the maximum length of the substring found
        return max_len;
    }
}
