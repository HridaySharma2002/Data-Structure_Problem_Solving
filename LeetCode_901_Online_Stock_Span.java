class StockSpanner {
    // Variable to keep track of the current index (day)
    int index;
    // Stack to store pairs of (index, price)
    Stack<int[]> stack;

    // Constructor to initialize the StockSpanner
    public StockSpanner() {
        stack = new Stack<>(); // Initialize the stack
        index = -1; // Set the initial index to -1 (no prices processed yet)
    }
    
    // Method to calculate the span for the given price
    public int next(int price) {
        index++; // Increment the index to represent the current day

        // Pop elements from the stack while the top price is less than or equal to the current price
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop(); // Remove the top element from the stack
        }

        // Calculate the span:
        // If the stack is empty, it means there are no previous prices greater than the current price
        // So, span is index - (-1) = index + 1
        // Otherwise, span is the difference between the current index and the index of the last higher price
        int span = index - (stack.isEmpty() ? -1 : stack.peek()[0]);

        // Push the current price and its index onto the stack
        stack.push(new int[]{index, price});
        
        // Return the calculated span
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
