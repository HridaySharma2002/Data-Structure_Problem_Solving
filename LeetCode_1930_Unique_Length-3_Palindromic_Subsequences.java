class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        // Arrays to store the first and last occurrence index of each character (a-z)
        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize all first and last occurrences to -1 (meaning not found yet)
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        // Traverse the string to fill first and last occurrence arrays
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';  // Convert character to index 0-25
            if (first[c] == -1) {
                first[c] = i;  // Set first occurrence if not set yet
            }
            last[c] = i;  // Update last occurrence to current index
        }

        int result = 0;  // To store the count of unique palindromic subsequences of length 3

        // Iterate over all characters from 'a' to 'z'
        for (int c = 0; c < 26; c++) {
            // Check if character appears at least twice with at least one character in between
            if (first[c] != -1 && last[c] - first[c] > 1) {
                int mask = 0;  // Bitmask to track unique characters between first[c] and last[c]

                // Check all characters between first[c] and last[c]
                for (int i = first[c] + 1; i < last[c]; i++) {
                    // Set the bit corresponding to the character at position i
                    mask |= 1 << (s.charAt(i) - 'a');
                }

                // Count how many unique characters are between first[c] and last[c]
                // Each unique character forms a unique palindrome of form c _ c
                result += Integer.bitCount(mask);
            }
        }

        return result;  // Return the total count of unique palindromic subsequences of length 3
    }
}
