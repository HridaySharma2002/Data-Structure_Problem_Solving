class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0; // Variable to store the total count of valid substrings
        int last_seen[] = {-1, -1, -1}; // Array to track the last seen indices of 'a', 'b', and 'c'

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Update the last seen index for the current character
            last_seen[s.charAt(i) - 'a'] = i;

            // Check if all three characters have been seen at least once
            if (last_seen[0] != -1 && last_seen[1] != -1 && last_seen[2] != -1) {
                // Calculate the number of valid substrings ending at the current index
                // This is done by adding 1 to the minimum last seen index of the three characters
                count += (1 + Math.min(last_seen[0], Math.min(last_seen[1], last_seen[2])));
            }
        }
        return count; // Return the total count of valid substrings
    }
}
