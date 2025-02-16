class Solution {
    public boolean checkValidString(String s) {
        int max = 0; // Maximum number of unmatched opening parentheses
        int min = 0; // Minimum number of unmatched opening parentheses

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If the character is an opening parenthesis
            if (s.charAt(i) == '(') {
                min++; // Increment min and max since we have an additional open parenthesis
                max++;
            }
            // If the character is a closing parenthesis
            else if (s.charAt(i) == ')') {
                min--; // Decrement min since we need to match an open parenthesis
                max--; // Decrement max since we have one more closing parenthesis
            }
            // If the character is a wildcard '*'
            else {
                min--; // Decrement min since '*' can be treated as a closing parenthesis
                max++; // Increment max since '*' can also be treated as an opening parenthesis
            }

            // If min goes below 0, reset it to 0
            // This means we have more closing parentheses than opening ones
            if (min < 0) {
                min = 0; // Reset min to 0 because we can't have negative unmatched open parentheses
            }
            // If max goes below 0, it means we have too many closing parentheses
            if (max < 0) {
                return false; // Return false as the string cannot be valid
            }
        }
        // At the end, for the string to be valid, min must be 0
        // This means all open parentheses have been matched
        return (min == 0);
    }
}
