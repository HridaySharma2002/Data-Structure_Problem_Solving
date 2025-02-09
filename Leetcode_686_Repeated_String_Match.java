class Solution {
    public int repeatedStringMatch(String a, String b) {
        // Create a StringBuilder to build the repeated string from 'a'
        StringBuilder s = new StringBuilder(a);
        int count = 1; // Initialize count to track the number of times 'a' is repeated

        // Repeat 'a' until the length of the built string is at least the length of 'b'
        while (s.length() < b.length()) {
            s.append(a); // Append 'a' to the StringBuilder
            count++; // Increment the count of repetitions
        }

        // Check if 'b' is a substring of the current built string
        if (s.indexOf(b) != -1) {
            return count; // If found, return the count
        }

        // Append 'a' one more time to check for 'b' in the next repetition
        s.append(a);
        count++; // Increment the count again

        // Check again if 'b' is a substring of the newly built string
        if (s.indexOf(b) != -1) {
            return count; // If found, return the count
        }

        // If 'b' is not found in the repeated strings, return -1
        return -1;
    }
}
