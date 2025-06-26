class Solution {
    // Main method to return the lexicographically smallest equivalent string
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Create an array to represent the parent of each character (0 for 'a', 1 for 'b', ..., 25 for 'z')
        int parent[] = new int[26];
        
        // Initialize each character to be its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i; // Each character is its own parent initially
        }

        // Build equivalence groups based on the characters in s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            // Convert characters to their corresponding indices
            int u = s1.charAt(i) - 'a'; // Index for character in s1
            int v = s2.charAt(i) - 'a'; // Index for character in s2
            
            // Find the root parents of both characters
            int pu = find(parent, u); // Root parent of character u
            int pv = find(parent, v); // Root parent of character v

            // Union by lexicographical order (keep the smaller one as the root)
            if (pu < pv) {
                parent[pv] = pu; // Make pu the parent of pv
            } else {
                parent[pu] = pv; // Make pv the parent of pu
            }
        }

        // Construct the result using the smallest equivalent character for each character in baseStr
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            // Find the smallest equivalent character for the current character in baseStr
            char mapped = (char) (find(parent, ch - 'a') + 'a'); // Convert index back to character
            result.append(mapped); // Append the mapped character to the result
        }

        return result.toString(); // Return the final result string
    }

    // Find operation with path compression to optimize future queries
    private int find(int[] parent, int x) {
        // If x is not its own parent, recursively find its root parent
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x]; // Return the root parent
    }
}
