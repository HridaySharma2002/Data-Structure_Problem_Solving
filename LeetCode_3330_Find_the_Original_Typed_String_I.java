class Solution {
    // Method to count the number of characters in the string
    // while reducing the count for each transition between different characters
    public int possibleStringCount(String word) {
        // Initialize count with the length of the input string
        int count = word.length();
        
        // Loop through the string starting from the second character
        for (int i = 1; i < word.length(); i++) {
            // Compare the current character with the previous character
            if (word.charAt(i) != word.charAt(i - 1)) {
                // If they are different, decrement the count
                count--;
            }
        }
        
        // Return the final count
        return count;
    }
}
