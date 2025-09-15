class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Create a boolean array to mark which letters are broken
        boolean[] broken = new boolean[26];
        // Mark the broken letters as true in the array
        for (char ch : brokenLetters.toCharArray()) {
            broken[ch - 'a'] = true;
        }
        int count = 0;      // To count the number of words that can be typed
        boolean okay = true; // Flag to check if the current word can be typed

        // Iterate through each character in the text (including one extra iteration for the last word)
        for (int i = 0; i <= text.length(); i++) {
            // If the current character is not a space and within bounds
            if (i < text.length() && text.charAt(i) != ' ') {
                // If the character is a broken letter, mark the word as not okay
                if (broken[text.charAt(i) - 'a']) {
                    okay = false;
                }
            } else {
                // If we reach a space or the end of the text, check if the word was okay
                if (okay) {
                    count++; // Increment count if the word can be typed
                }
                okay = true; // Reset for the next word
            }
        }
        return count; // Return the total number of typable words
    }
}
