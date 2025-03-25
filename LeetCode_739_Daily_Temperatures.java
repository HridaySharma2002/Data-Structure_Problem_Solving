class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; // Get the length of the temperatures array
        int result[] = new int[n]; // Initialize the result array to store the number of days until a warmer temperature
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices of the temperatures

        // Iterate through the temperatures array
        for (int i = 0; i < n; i++) {
            // While there are indices in the stack and the current temperature is greater than 
            //  the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pop the index from the stack
                int index = stack.pop();
                // Calculate the number of days until a warmer temperature
                result[index] = i - index; // Store the difference in days in the result array
            }
            // Push the current index onto the stack for future comparisons
            stack.push(i);
        }
        // Return the result array containing the number of days to wait for a warmer temperature
        return result;
    }
}
