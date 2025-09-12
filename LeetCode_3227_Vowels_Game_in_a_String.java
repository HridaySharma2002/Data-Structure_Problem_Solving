class Solution {
    public boolean doesAliceWin(String s) {
        // Create a set containing all vowels for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the character is a vowel, Alice can make a move by removing this single vowel substring
            if (vowels.contains(ch)) {
                return true;  // Alice wins
            }
        }
        
        // If no vowels are found, Alice cannot make any move and loses
        return false;
    }
}
