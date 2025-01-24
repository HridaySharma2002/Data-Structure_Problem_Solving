class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize pointers for the sliding window
        int right = 0; // Right pointer to expand the window
        int left = 0;  // Left pointer to shrink the window
        int max_len = 0; // Variable to store the maximum length of substring found
        HashMap<Character, Integer> map = new HashMap<>(); // HashMap to store the last index of each character

        // Iterate through the string using the right pointer
        while (right < s.length()) {
            // Check if the character at the right pointer is already in the HashMap
            if (map.containsKey(s.charAt(right))) {
                // Move the left pointer to the right of the last occurrence of the character
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }

            // Update the last index of the character in the HashMap
            map.put(s.charAt(right), right);

            // Calculate the length of the current substring and update max_len if it's larger
            max_len = Math.max(max_len, right - left + 1);

            // Move the right pointer to the right to expand the window
            right++;
        }

        // Return the maximum length of substring found without repeating characters
        return max_len;
    }
}
