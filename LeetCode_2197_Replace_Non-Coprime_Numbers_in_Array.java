class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // Use a stack (implemented as an ArrayList) to keep track of the current sequence
        List<Integer> stack = new ArrayList<>();
        
        // Iterate through each number in the input array
        for (int num : nums) {
            // Try to merge with the top of the stack as long as the stack is not empty
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1); // Get the last element in the stack
                int g = gcd(top, num); // Compute GCD of top and current number
                if (g == 1) {
                    // If they are coprime, stop merging
                    break;
                }
                // If not coprime, remove the top and merge with current number using LCM
                stack.remove(stack.size() - 1);
                num = (top / g) * num; // Calculate LCM in a way that avoids overflow
            }
            // Push the (possibly merged) number onto the stack
            stack.add(num);
        }
        // The stack now contains the final array after all possible merges
        return stack;
    }

    // Helper method to compute the Greatest Common Divisor (GCD) using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a; // Base case: if b is 0, GCD is a
        }
        return gcd(b, a % b); // Recursive call
    }
}
