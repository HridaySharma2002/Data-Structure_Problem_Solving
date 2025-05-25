class Solution {
    public int lengthAfterTransformations(String s, int t) {
        // Define the modulo constant to handle large numbers
        final int kMod = 1_000_000_007;
        
        // Array to count occurrences of each character (a-z)
        int count[] = new int[26];
        
        // Count the occurrences of each character in the input string
        for (char c : s.toCharArray()) {
            count[c - 'a']++; // Increment the count for the character
        }

        // Perform transformations t times
        while (t-- > 0) {
            int[] newcount = new int[26]; // New array to hold transformed counts
            
            // Shift characters from 'a' to 'y' to the next character
            for (int i = 0; i < 25; i++) {
                newcount[i + 1] = count[i]; // Move count of character i to i+1
            }

            // Handle 'z' transformation: 'z' becomes 'a' and 'b'
            newcount[0] = (newcount[0] + count[25]) % kMod; // 'z' contributes to 'a'
            newcount[1] = (newcount[1] + count[25]) % kMod; // 'z' contributes to 'b'
            
            count = newcount; // Update count for the next transformation
        }

        // Calculate the total length of the resulting string
        int totalcount = 0;
        for (int c : count) {
            totalcount = (totalcount + c) % kMod; // Sum counts and apply modulo
        }

        return totalcount; // Return the final length of the transformed string
    }
}
