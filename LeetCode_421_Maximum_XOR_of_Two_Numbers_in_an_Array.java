class Solution {
    // Method to find the maximum XOR of two numbers in the given array
    public int findMaximumXOR(int[] nums) {
        // Create a new Trie to store the binary representations of the numbers
        Trie trie = new Trie();
        
        // Insert each number into the Trie
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }
        
        int maximum = 0; // Variable to keep track of the maximum XOR found
        
        // For each number, check the maximum XOR it can produce with the numbers in the Trie
        for (int i = 0; i < nums.length; i++) {
            maximum = Math.max(maximum, trie.check_max(nums[i]));
        }

        return maximum; // Return the maximum XOR found
    }
}

class Trie {
    // Inner class representing a node in the Trie
    class Node {
        Node links[] = new Node[2]; // Array to hold links for binary digits (0 and 1)

        // Check if the current node contains a link for the given bit
        boolean containsKey(int bits) {
            return links[bits] != null;
        }

        // Get the node corresponding to the given bit
        Node get(int bits) {
            return links[bits];
        }

        // Put a new node for the given bit
        void put(int bits, Node node) {
            links[bits] = node;
        }
    }

    Node root; // Root node of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new Node();
    }

    // Method to insert a number into the Trie
    public void insert(int num) {
        Node node = root;
        // Iterate through each bit of the number from the most significant bit to the least
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // Extract the current bit
            // If the current bit's node does not exist, create it
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit); // Move to the next node
        }
    }

    // Method to find the maximum XOR for a given number with the numbers in the Trie
    public int check_max(int num) {
        Node node = root;
        int maxi = 0; // Variable to store the maximum XOR value
        // Iterate through each bit of the number from the most significant bit to the least
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // Extract the current bit
            // Check if the opposite bit exists in the Trie (to maximize XOR)
            if (node.containsKey(1 - bit)) {
                maxi = maxi | (1 << i); // Set the corresponding bit in the maximum value
                node = node.get(1 - bit); // Move to the node for the opposite bit
            } else {
                node = node.get(bit); // Move to the node for the current bit
            }
        }
        return maxi; // Return the maximum XOR found for the given number
    }
}
