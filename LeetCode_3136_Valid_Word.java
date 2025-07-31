class Solution {
    public boolean isValid(String word) {
        // Check if the word length is at least 3 characters
        if(word.length() < 3){
            return false;
        }

        boolean hasVowel = false;      // Flag to track presence of at least one vowel
        boolean hasConsonant = false;  // Flag to track presence of at least one consonant

        String vowels = "aeiouAEIOU";  // String containing all vowels (both lowercase and uppercase)

        // Iterate through each character in the word
        for(char c : word.toCharArray()){
            // If character is not a digit or letter, return false immediately
            if(!Character.isLetterOrDigit(c)){
                return false;
            }

            // If character is a letter, check if it is vowel or consonant
            if(Character.isLetter(c)){
                if(vowels.indexOf(c) != -1){
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        // Return true only if word contains at least one vowel and one consonant
        return hasVowel && hasConsonant;
    }
}
