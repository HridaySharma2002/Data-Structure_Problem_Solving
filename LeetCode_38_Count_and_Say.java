class Solution {
    public String countAndSay(int n) {
        // Base case: if n is 1, return "1" as the first term of the sequence
        if (n == 1) {
            return "1";
        }

        // Recursively get the previous term in the sequence
        String previous_term = countAndSay(n - 1);
        // StringBuilder to construct the current term
        StringBuilder current_term = new StringBuilder();

        // Initialize the first character and a count variable
        char current_char = previous_term.charAt(0);
        int count = 0;

        // Iterate through each character in the previous term
        for (char ch : previous_term.toCharArray()) {
            // If the current character matches the character being counted
            if (ch == current_char) {
                count++; // Increment the count
            } else {
                // If the character changes, append the count and the character to the current term
                current_term.append(count).append(current_char);
                // Update current_char to the new character
                current_char = ch;
                // Reset count for the new character
                count = 1;
            }
        }
        // Append the last counted character and its count to the current term
        current_term.append(count).append(current_char);

        // Return the constructed current term as a string
        return current_term.toString();
    }
}
