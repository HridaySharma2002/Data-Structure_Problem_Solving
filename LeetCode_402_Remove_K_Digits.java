import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        // Create a stack to store the digits of the resulting number
        Stack<Character> stack = new Stack<>();
        // String to hold the intermediate result
        String res = "";

        // Iterate through each digit in the input number
        for (int i = 0; i < num.length(); i++) {
            // While there are digits in the stack, we can remove the top digit
            // if the current digit is smaller and we still have digits to remove (k > 0)
            while (!stack.isEmpty() && k > 0 && (stack.peek() - '0') > (num.charAt(i) - '0')) {
                stack.pop(); // Remove the top digit from the stack
                k--; // Decrease the count of digits to remove
            }
            // Push the current digit onto the stack
            stack.push(num.charAt(i));
        }

        // If there are still digits to remove, pop them from the stack
        while (k > 0) {
            stack.pop();
            k--;
        }

        // If the stack is empty, it means all digits were removed
        if (stack.isEmpty()) {
            return "0"; // Return "0" as the result
        }

        // Build the result string by popping from the stack
        while (!stack.isEmpty()) {
            res += stack.pop(); // Append the digits to the result
        }

        // Prepare to construct the final result without leading zeros
        String result = "";
        boolean leading_zero = true; // Flag to track leading zeros

        // Iterate through the result string in reverse order
        for (int i = res.length() - 1; i >= 0; i--) {
            // Append non-zero digits or the first non-zero digit
            if (res.charAt(i) != '0' || !leading_zero) {
                leading_zero = false; // Found a non-zero digit
                result += res.charAt(i); // Append the digit to the final result
            }
        }

        // If the result is empty, return "0"; otherwise, return the constructed result
        return result.length() == 0 ? "0" : result;
    }
}
