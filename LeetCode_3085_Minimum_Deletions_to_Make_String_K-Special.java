class Solution {
    public int minimumDeletions(String word, int k) {
        // Handle edge cases: if the string is empty or has only one character
        if(word.length() == 0 || word.length() == 1) {
            return 0; // No deletions needed
        }

        // Step 1: Create an array to count the frequency of each character
        int freq[] = new int[26]; // There are 26 lowercase English letters
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++; // Increment the frequency for the character
        }

        // Step 2: Initialize the minimum deletions to a large value
        int minDeletions = Integer.MAX_VALUE;

        // Step 3: Iterate through each frequency to consider it as a base frequency
        for(int base : freq) {
            if(base == 0) {
                continue; // Skip zero frequencies
            }

            int deletions = 0; // Initialize deletions for this base frequency

            // Step 4: Calculate the number of deletions needed for each frequency
            for(int f : freq) {
                if(f < base) {
                    // If frequency is less than base, delete all occurrences
                    deletions += f;
                } else if(f > base + k) {
                    // If frequency is greater than base + k, delete the excess
                    deletions += f - (base + k);
                }
            }

            // Step 5: Update the minimum deletions found
            minDeletions = Math.min(minDeletions, deletions);
        }

        // Step 6: Return the minimum deletions required to make the string k-special
        return minDeletions;
    }
}
