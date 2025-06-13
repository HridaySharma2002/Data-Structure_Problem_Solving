class Solution {
    public int longestPalindrome(String[] words) {
        // Create a HashMap to count occurrences of each two-letter word
        Map<String, Integer> count = new HashMap<>();
        int length = 0; // Variable to store the total length of the longest palindrome

        // Count occurrences of each word
        for (String word : words) {
            // Increment the count for the current word, defaulting to 0 if not present
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        boolean hasCentre = false; // Flag to check if we can have a center palindrome word

        // Iterate through each unique word in the count map
        for (String word : count.keySet()) {
            // Create the reverse of the current word
            String reverse = new StringBuilder(word).reverse().toString();

            // Check if the word is a palindrome itself (e.g., "aa", "bb", "cc", etc.)
            if (word.equals(reverse)) {
                // Add the length contributed by pairs of this palindrome word
                length += (count.get(word) / 2) * 4; // Add pairs of the same word (each pair contributes 4 to the length)
                // If there's an odd count, we can use one as the center of the palindrome
                if (count.get(word) % 2 == 1) {
                    hasCentre = true; // Set the flag to true if there's an odd count
                }
            } else if (count.containsKey(reverse)) {
                // If the word has a reverse counterpart (e.g., "ab" and "ba")
                // Add the minimum count of pairs that can be formed
                length += Math.min(count.get(word), count.get(reverse)) * 4; // Each pair contributes 4 to the length
                count.put(reverse, 0); // Set the count of the reverse word to 0 to avoid double counting
            }
        }

        // If we found a center word, we can add 2 to the total length
        if (hasCentre) {
            length += 2; // Add 2 for the center palindrome word
        }

        return length; // Return the total length of the longest palindrome
    }
}
