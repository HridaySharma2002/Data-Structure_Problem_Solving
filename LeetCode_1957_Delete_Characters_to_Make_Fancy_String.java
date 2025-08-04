class Solution {
    public String makeFancyString(String s) {
        // Convert the input string to a character array for easy manipulation
        char chars[] = s.toCharArray(); 
        
        // Initialize 'last' to the first character, 'count' to 1 (since first char is counted), and 'pos' to 1 (next write position)
        char last = chars[0];
        int count = 1;
        int pos = 1;
        
        // Start from the second character and iterate through the array
        for (int i = 1; i < chars.length; i++) {
            // If the current character is different from the last, reset 'last' and 'count'
            if (chars[i] != last) {
                last = chars[i];
                count = 0;
            }
            // Increment the count for consecutive characters
            if (++count > 2) {
                // If more than two consecutive characters, skip adding this character
                continue;
            }
            // Otherwise, add the character to the next position in the array
            chars[pos++] = chars[i];
        }

        // Construct a new string from the first 'pos' characters of the array and return it
        return new String(chars, 0, pos);
    }
}
