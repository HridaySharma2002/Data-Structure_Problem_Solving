class Solution {
    public char kthCharacter(int k) {
        // Calculate k - 1 to convert from 1-indexed to 0-indexed.
        // This is necessary because array and string indices in Java start at 0.
        // For example, if k = 1, we want to find the character at index 0.
        
        // Count the number of 1-bits in the binary representation of (k - 1).
        // This count represents how many transformations have occurred.
        // Each transformation corresponds to moving to the next character in the alphabet.
        
        // The expression 'Integer.bitCount(k - 1)' gives us the number of transformations.
        // We then add this count to the ASCII value of 'a' to get the resulting character.
        
        return (char)('a'+Integer.bitCount(k-1));
    }
}
