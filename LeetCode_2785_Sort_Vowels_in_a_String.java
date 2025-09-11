class Solution {
    public String sortVowels(String s) {
        // Create a list to store all vowels found in the string
        List<Character> vowels = new ArrayList<>();
        
        // First pass: collect all vowels from the input string
        for (char ch : s.toCharArray()) {
            // Check if the character is a vowel (either uppercase or lowercase)
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                vowels.add(ch); // Add vowel to the list
            }
        }
        
        // Sort the collected vowels in ascending order
        Collections.sort(vowels);
        
        // StringBuilder to build the final result string
        StringBuilder result = new StringBuilder();
        // Index to keep track of the position in the sorted vowels list
        int vowelindex = 0;
        
        // Second pass: reconstruct the string
        for (char ch : s.toCharArray()) {
            // If the character is a vowel, replace it with the next sorted vowel
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                result.append(vowels.get(vowelindex++));
            } else {
                // If not a vowel, keep the original character
                result.append(ch);
            }
        }
        
        // Convert StringBuilder to String and return the result
        return result.toString();
    }
}
