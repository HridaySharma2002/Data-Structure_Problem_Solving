class Solution {
    public int maxOperations(String s) {
        int ones = 0;      // Counts the number of '1's encountered so far in the string
        int result = 0;    // Accumulates the total number of valid operations possible

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // If current character is '1', increment the count of ones
                ones++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                // If current character is '0' and the previous character is '1',
                // it means we found a "10" pattern where an operation can be performed.
                // Add the total number of ones seen so far to the result.
                result += ones;
            }
        }

        // Return the total number of operations possible
        return result;
    }
}
