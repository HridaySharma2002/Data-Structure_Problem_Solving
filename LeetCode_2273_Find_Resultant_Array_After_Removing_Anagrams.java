class Solution {
    public List<String> removeAnagrams(String[] words) {
        // Initialize the result list to store the final words after removing anagrams
        List<String> result = new ArrayList<>();
        // This string will keep the sorted version of the previous word
        String prevsorted = "";
        // Iterate through each word in the input array
        for (String word : words) {
            // Convert the current word to a character array for sorting
            char arr[] = word.toCharArray();
            // Sort the character array to get the canonical form of the word
            Arrays.sort(arr);
            // Convert the sorted character array back to a string
            String currsorted = new String(arr);
            // If the current word's sorted form is not equal to the previous,
            // it means it's not an anagram of the previous word
            if (!currsorted.equals(prevsorted)) {
                // Add the current word to the result list
                result.add(word);
                // Update prevsorted to the current word's sorted form
                prevsorted = currsorted;
            }
            // If it is an anagram, skip adding it to the result
        }
        // Return the final list after removing consecutive anagrams
        return result;
    }
}
