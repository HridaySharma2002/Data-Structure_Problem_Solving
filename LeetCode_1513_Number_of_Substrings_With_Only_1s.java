class Solution {
    public int numSub(String s) {
        // Define the modulo constant to avoid integer overflow
        long MOD = 1_000_000_007;

        long result = 0;  // To accumulate the total number of substrings with only '1's
        long count1 = 0;  // To count the current consecutive streak of '1's

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;  // Increment streak count for consecutive '1's
                // Add the current streak count to result
                // Each new '1' extends all previous substrings ending at this position
                result = (result + count1) % MOD;  // Apply modulo to keep result within bounds
            } else {
                // Reset streak count when a '0' is encountered
                count1 = 0;
            }
        }

        // Return the final count as an integer
        return (int) result;
    }
}
