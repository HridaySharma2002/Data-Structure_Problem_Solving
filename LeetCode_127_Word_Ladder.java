// Class to represent a pair of values: a String and an integer
class Pair {
    String first; // The first element of the pair (a word)
    int second;   // The second element of the pair (the number of steps)

    // Constructor to initialize the Pair object
    Pair(String first, int second) {
        this.first = first;   // Assign the first value
        this.second = second; // Assign the second value
    }
}

class Solution {
    // Method to find the length of the shortest transformation sequence from beginWord to endWord
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Queue to hold pairs of words and their corresponding step counts
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1)); // Start with the beginWord at step 1

        // Set to hold the words for quick lookup
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        
        // Add all words from wordList to the set
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        
        // Remove the beginWord from the set to avoid revisiting
        st.remove(beginWord);

        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            String word = queue.peek().first; // Get the current word
            int steps = queue.peek().second;   // Get the current step count
            queue.remove(); // Remove the processed pair from the queue
            
            // Check if the current word is the endWord
            if (word.equals(endWord)) {
                return steps; // Return the number of steps if found
            }

            // Iterate through each character of the current word
            for (int i = 0; i < word.length(); i++) {
                // Try replacing the current character with every letter from 'a' to 'z'
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replaced_char_array[] = word.toCharArray(); // Convert word to char array
                    replaced_char_array[i] = ch; // Replace the character at position i
                    String replaced_word = new String(replaced_char_array); // Create new word

                    // If the new word is in the set, process it
                    if (st.contains(replaced_word)) {
                        st.remove(replaced_word); // Remove the word from the set to avoid revisiting
                        queue.add(new Pair(replaced_word, steps + 1)); // Add new pair to the queue
                    }
                }
            }
        }
        return 0; // Return 0 if no transformation sequence is found
    }
}
