public class Trie {
    // Node class represents each node in the Trie
    class Node {
        // Array to store links to child nodes, each index represents a letter (a-z)
        Node[] links = new Node[26];
        // Flag indicating if the node marks the end of a word
        boolean flag = false;

        // Check if the node contains a specific key (letter)
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null; // Returns true if the link for the character exists
        }

        // Insert a new node with a specific key (letter) into the Trie
        void put(char ch, Node node) {
            links[ch - 'a'] = node; // Assign the new node to the corresponding index
        }

        // Get the node with a specific key (letter) from the Trie
        Node get(char ch) {
            return links[ch - 'a']; // Return the child node corresponding to the character
        }

        // Set the current node as the end of a word
        void setEnd() {
            flag = true; // Mark this node as the end of a word
        }

        // Check if the current node marks the end of a word
        boolean isEnd() {
            return flag; // Return true if this node is the end of a word
        }
    }

    // Root node of the Trie
    Node root;

    // Constructor to initialize the Trie with an empty root node
    public Trie() {
        root = new Node(); // Create a new root node
    }
    
    // Inserts a word into the Trie
    public void insert(String word) {
        Node node = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            // Check if the current character node exists
            if (!node.containsKey(word.charAt(i))) {
                // Create a new node for the letter if not present
                node.put(word.charAt(i), new Node());
            }
            // Move to the next node in the Trie
            node = node.get(word.charAt(i));
        }
        // Mark the last node as the end of the word
        node.setEnd();
    }
    
    // Returns true if the word is in the Trie
    public boolean search(String word) {
        Node node = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            // If a letter is not found, the word is not in the Trie
            if (!node.containsKey(word.charAt(i))) {
                return false; // Return false if the character is missing
            }
            // Move to the next node in the Trie
            node = node.get(word.charAt(i));
        }
        // Check if the last node marks the end of a word
        return node.isEnd(); // Return true if the last node is the end of a word
    }
    
    // Returns true if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) {
            // If a letter is not found, there is no word with the given prefix
            if (!node.containsKey(prefix.charAt(i))) {
                return false; // Return false if the character is missing
            }
            // Move to the next node in the Trie
            node = node.get(prefix.charAt(i));
        }
        // The prefix is found in the Trie
        return true; // Return true if the prefix exists
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie(); // Create a new Trie instance
 * obj.insert(word); // Insert a word into the Trie
 * boolean param_2 = obj.search(word); // Search for a word in the Trie
 * boolean param_3 = obj.startsWith(prefix); // Check if any word starts with the given prefix
 */
