class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0; // Pointer for str2
        // Iterate through each character in str1
        for (int i = 0; i < str1.length(); i++) {
            // Check if the current character in str1 matches the current character in str2
            // or if the character in str1 can be transformed to match the character in str2
            if (str1.charAt(i) == str2.charAt(j) || (str1.charAt(i) - 'a' + 1) % 26 == (str2.charAt(j) - 'a')) {
                j++; // Move to the next character in str2
            }
            // If we have matched all characters in str2, return true
            if (j == str2.length()) {
                return true;
            }
        }
        // If we finish the loop without matching all characters in str2, return false
        return false;
    }
}
