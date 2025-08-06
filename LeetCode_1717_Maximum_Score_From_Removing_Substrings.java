class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0; // Total score to be returned
        char[] chars = s.toCharArray(); // Convert input string to character array for easy traversal
        int len = chars.length; // Length of the character array

        // ch1 and ch2 represent the characters of the higher-value substring to remove first
        char ch1 = 'a';
        char ch2 = 'b';
        int cnt1 = 0; // Counter for unmatched ch1 characters
        int cnt2 = 0; // Counter for unmatched ch2 characters

        // If x < y, swap x and y, and also swap ch1 and ch2
        // This ensures we always remove the higher-value substring first
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            ch1 = 'b';
            ch2 = 'a';
        }

        // Traverse the character array
        for (int i = 0; i < len; i++) {
            if (chars[i] == ch1) {
                // If current character is ch1, increment cnt1
                cnt1++;
            } else if (chars[i] == ch2) {
                // If current character is ch2
                if (cnt1 > 0) {
                    // If there is an unmatched ch1, pair it with ch2 to form ch1ch2 substring
                    cnt1--;
                    score += x; // Add the higher value to score
                } else {
                    // Otherwise, increment cnt2 (unmatched ch2)
                    cnt2++;
                }
            } else {
                // If current character is neither ch1 nor ch2, process leftovers in the segment
                // Pair up as many ch1 and ch2 as possible for the lower-value substring
                score += Math.min(cnt1, cnt2) * y;
                // Reset counters for the next segment
                cnt1 = 0;
                cnt2 = 0;
            }
        }

        // After the loop, process any remaining unmatched ch1 and ch2
        if (cnt1 != 0) {
            score += Math.min(cnt1, cnt2) * y;
        }

        return score; // Return the maximum score obtained
    }
}
