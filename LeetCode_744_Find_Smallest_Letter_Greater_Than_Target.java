class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Iterate through each character in the letters array
        for (int i = 0; i < letters.length; i++) {
            // Check if the current letter is lexicographically greater than the target
            // We compare by subtracting 'a' to convert chars to zero-based indices for clarity
            if ((letters[i] - 'a') > (target - 'a')) {
                // Return the first letter found that is greater than target
                return letters[i];
            }
        }
        // If no letter is greater than target, return the first letter (wrap-around case)
        return letters[0];
    }
}
