class Solution {
    // Method to find the minimum window substring of s that contains all characters of t
    public String minWindow(String s, String t) {
        // Edge case: if t is longer than s, it's impossible to find a valid substring
        if (t.length() > s.length()) {
            return "";
        }

        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        int count = 0; // Count of characters matched
        int s_index = -1; // Starting index of the minimum substring
        int min_len = Integer.MAX_VALUE; // Minimum length of the substring found
        int[] hash = new int[256]; // Frequency map for characters in t

        // Populate the hash array with the frequency of each character in t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        // Expand the window with the right pointer
        while (right < s.length()) {
            // If the character at the right pointer is part of t, increase the count
            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            // Decrease the frequency of the current character in the hash
            hash[s.charAt(right)]--;

            // Contract the window until it ceases to be 'desirable'
            while (count == t.length()) {
                // Update the minimum length and starting index if a smaller window is found
                if ((right - left + 1) < min_len) {
                    min_len = right - left + 1;
                    s_index = left;
                }

                // Remove the leftmost character from the window
                hash[s.charAt(left)]++;
                // If the character is part of t and its frequency goes above zero, decrease the count
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++; // Move the left pointer to the right
            }
            right++; // Move the right pointer to the right to expand the window
        }

        // Return the smallest substring or an empty string if no valid substring was found
        return s_index == -1 ? "" : s.substring(s_index, s_index + min_len);
    }
}
