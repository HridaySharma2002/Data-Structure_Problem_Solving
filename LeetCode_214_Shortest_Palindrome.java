class Solution {
    // Method to find the shortest palindrome by adding characters in front of the string
    public String shortestPalindrome(String s) {
        // Edge case: if the string is null or empty, return an empty string
        if (s == null || s.length() == 0) {
            return "";
        }

        // Create a new string that is the reverse of s
        String rev = new StringBuilder(s).reverse().toString();
        
        // Concatenate the original string, a special character, and the reversed string
        // The special character '#' is used to avoid overlap between the original and reversed strings
        String combined = s + "#" + rev;

        // Create an array to hold the longest prefix suffix (LPS) values for the combined string
        int lps[] = new int[combined.length()];
        
        // Compute the LPS array for the combined string
        computelpsarray(combined, lps);

        // The length of the longest palindromic prefix in the original string
        int palLen = lps[lps.length - 1];

        // Determine the characters that need to be added to the front of the original string
        // This is done by taking the substring from the reversed string
        String toAdd = rev.substring(0, s.length() - palLen);

        // Return the new string formed by adding the necessary characters in front of the original string
        return toAdd + s;
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
                lps[i] = length;
                i++;
            } else {
                // If characters do not match and length is not zero, use the previous LPS value
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    // If length is zero, set lps[i] to 0 and move to the next character
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
