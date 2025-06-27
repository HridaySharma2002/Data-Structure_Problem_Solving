class Solution {
    public String robotWithString(String s) {
        // Initialize an array to count the frequency of each character (a-z)
        int freq[] = new int[26];
        
        // Count the frequency of each character in the input string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; // Increment the count for the character
        }
        
        // Stack to hold characters temporarily
        Stack<Character> stack = new Stack<>();
        // StringBuilder to build the final result
        StringBuilder result = new StringBuilder();
        // Variable to track the smallest character available
        int minChar = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            // Push the current character onto the stack
            stack.push(ch);
            // Decrease the frequency of the current character
            freq[ch - 'a']--;

            // Update minChar to the next smallest character that is still available
            while (minChar < 26 && freq[minChar] == 0) {
                minChar++;
            }

            // Pop characters from the stack to the result if they are less than or equal to the smallest available character
            while (!stack.isEmpty() && stack.peek() <= ('a' + minChar)) {
                result.append(stack.pop()); // Append the character to the result
            }
        }

        // Return the final rearranged string
        return result.toString();
    }
}
