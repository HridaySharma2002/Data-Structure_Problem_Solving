class Solution {
    public int maxDistance(String st, int k) {
        // Initialize counters for each direction
        int n = 0; // Count of 'N' (North)
        int s = 0; // Count of 'S' (South)
        int e = 0; // Count of 'E' (East)
        int w = 0; // Count of 'W' (West)
        
        // Variable to track the maximum Manhattan distance
        int max = 0; 
        
        // Iterate through each character in the input string
        for (char c : st.toCharArray()) {
            // Increment the respective direction counter based on the character
            if (c == 'N') {
                n++; // Move North
            } else if (c == 'S') {
                s++; // Move South
            } else if (c == 'E') {
                e++; // Move East
            } else {
                w++; // Move West
            }

            // Calculate the maximum distance for different combinations of dominant directions
            // Combination 1: Dominant directions are North and East
            max = Math.max(max, n + e - s - w + 2 * Math.min(s + w, k));
            // Combination 2: Dominant directions are North and West
            max = Math.max(max, n + w - s - e + 2 * Math.min(s + e, k));
            // Combination 3: Dominant directions are South and East
            max = Math.max(max, s + e - n - w + 2 * Math.min(n + w, k));
            // Combination 4: Dominant directions are South and West
            max = Math.max(max, s + w - n - e + 2 * Math.min(n + e, k));
        }

        // Return the maximum distance found
        return max;
    }
}
