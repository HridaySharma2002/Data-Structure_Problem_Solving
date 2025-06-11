class Solution {
    // Method to find indices of words containing a specific character
    public List<Integer> findWordsContaining(String[] words, char x) {
        // Initialize an empty list to store the indices of words containing the character
        List<Integer> result = new ArrayList<>();
        
        // Loop through each word in the provided array
        for (int i = 0; i < words.length; i++) {
            // Check if the current word contains the character x
            if (words[i].indexOf(x) != -1) {
                // If found, add the index of the word to the result list
                result.add(i);
            }
        }
        
        // Return the list of indices
        return result;
    }
}
