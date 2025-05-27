class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // Initialize a list to store the resulting words
        List<String> result = new ArrayList<>();
        
        // Always add the first word to the result
        result.add(words[0]);
        
        // Store the group of the last added word
        int prev = groups[0];
        
        // Iterate through the groups starting from the second element
        for (int i = 1; i < groups.length; i++) {
            // Check if the current group's value is different from the previous one
            if (prev != groups[i]) {
                // If different, add the corresponding word to the result
                result.add(words[i]);
                
                // Update the previous group to the current one
                prev = groups[i];
            }
        }
        
        // Return the list of selected words
        return result;
    }
}
