class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;         // Initialize a variable to store the length of the last word
        s = s.trim();           // Remove leading and trailing spaces from the string

        // Iterate from the end of the string towards the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // If the current character is not a space
                length++;              // Increment the length counter
            } else if (length > 0) {   // If a space is found after counting some characters
                break;                 // Break the loop as we've found the last word
            }
        }
        return length; // Return the length of the last word
    }
}
