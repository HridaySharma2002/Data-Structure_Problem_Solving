class Solution {
    public int minAddToMakeValid(String s) {
        // Initialize counters for unmatched opening and closing parentheses
        int open_count = 0;  // Count of unmatched opening parentheses
        int close_count = 0; // Count of unmatched closing parentheses

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the character is an opening parenthesis, increment the open_count
            if (ch == '(') {
                open_count++;
            }
            // If the character is a closing parenthesis
            else if (ch == ')') {
                // Check if there is a matching opening parenthesis
                if (open_count > 0) {
                    open_count--; // Match found, decrement open_count
                } else {
                    close_count++; // No match, increment close_count
                }
            }
        }

        // The total number of moves required is the sum of unmatched opening and closing parentheses
        return open_count + close_count;
    }
}
