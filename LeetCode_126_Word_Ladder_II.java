class Solution {
    String b; // The target word to reach
    HashMap<String,Integer> map; // A map to store the words and their corresponding step counts
    List<List<String>> result; // A list to store all the transformation sequences

    // Depth-first search (DFS) method to find all paths from the current word to the target word
    private void dfs(String word, List<String> seq) {
        // If the current word matches the target word
        if (word.equals(b)) {
            // Create a temporary list to store the current sequence
            List<String> temp = new ArrayList<>(seq);
            // Reverse the sequence to show the path from start to end
            Collections.reverse(temp);
            // Add the found sequence to the result list
            result.add(temp);
            return;
        }

        // Get the number of steps taken to reach the current word
        int steps = map.get(word);
        int len = word.length();
        // Iterate through each character position in the word
        for (int i = 0; i < len; i++) {
            // Try replacing the character at position i with every letter from 'a' to 'z'
            for (char c = 'a'; c <= 'z'; c++) {
                char replacedCharArray[] = word.toCharArray(); // Convert the word to a character array
                replacedCharArray[i] = c; // Replace the character at position i
                String replacedWord = new String(replacedCharArray); // Create a new word from the modified array
                // Check if the replaced word exists in the map and is one step before the current word
                if (map.containsKey(replacedWord) && map.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord); // Add the replaced word to the current sequence
                    dfs(replacedWord, seq); // Recursively call DFS with the new word
                    seq.remove(seq.size() - 1); // Backtrack by removing the last word added
                }
            }
        }
    }

    // Main method to find all transformation sequences from beginWord to endWord
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(); // Set to store the word list for quick lookup
        int len = wordList.size();
        // Add all words from the word list to the set
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        Queue<String> queue = new LinkedList<>(); // Queue for BFS
        b = beginWord; // Set the target word
        queue.add(beginWord); // Start with the beginWord
        map = new HashMap<>(); // Initialize the map
        map.put(beginWord, 1); // Mark the beginWord with step count 1
        int size = beginWord.length();
        st.remove(beginWord); // Remove the beginWord from the set

        // Perform BFS to find the shortest path to the endWord
        while (!queue.isEmpty()) {
            String word = queue.remove(); // Get the current word from the queue
            int steps = map.get(word); // Get the number of steps taken to reach this word
            // If the current word is the endWord, stop the search
            if (word.equals(endWord)) {
                break;
            }
            // Iterate through each character position in the word
            for (int i = 0; i < size; i++) {
                // Try replacing the character at position i with every letter from 'a' to 'z'
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray(); // Convert the word to a character array
                    replacedCharArray[i] = ch; // Replace the character at position i
                    String replacedWord = new String(replacedCharArray); // Create a new word from the modified array
                    // If the replaced word is in the set, add it to the queue
                    if (st.contains(replacedWord) == true) {
                        queue.add(replacedWord); // Add the new word to the queue
                        st.remove(replacedWord); // Remove it from the set to avoid revisiting
                        map.put(replacedWord, steps + 1); // Update the step count for the new word
                    }
                }
            }
        }

        result = new ArrayList<>(); // Initialize the result list
        // If the endWord was reached, initiate DFS to find all paths
        if (map.containsKey(endWord) == true) {
            List<String> seq = new ArrayList<>(); // Create a new sequence list
            seq.add(endWord); // Start the sequence with the endWord
            dfs(endWord, seq); // Call DFS to find all paths to the beginWord
        }

        return result; // Return the list of all transformation sequences
    }
}
