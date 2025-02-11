class Solution {
    // Method to find the longest prefix which is also a suffix in the given string
    public String longestPrefix(String s) {
        // Edge case: if the string is null or empty, return an empty string
        if (s == null || s.length() == 0) {
            return "";
        }

        // Create an array to hold the longest prefix suffix (LPS) values
        int lps[] = new int[s.length()];
        
        // Compute the LPS array for the input string
        computelpsarray(s, lps);

        // The length of the longest prefix which is also a suffix is found in the last position of the LPS array
        int length = lps[lps.length - 1];

        // Return the longest prefix, which is the substring from the start to the length found
        return s.substring(0, length);
    }

    // Helper method to compute the LPS (Longest Prefix Suffix) array
    public void computelpsarray(String s, int[] lps) {
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character

        // Loop through the string to fill the LPS array
        while (i < s.length()) {
            // If characters match, increment length and set lps[i]
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length; // Store the length of the current longest prefix suffix
                i++; // Move to the next character
            } else {
                // If characters do not match and length is not zero, use the previous LPS value
                if (length != 0) {
                    length = lps[length - 1]; // Update length to the last known prefix suffix length
                } else {
                    // If length is zero, set lps[i] to 0 and move to the next character
                    lps[i] = 0; // No prefix suffix found
                    i++;
                }
            }
        }
    }
}
