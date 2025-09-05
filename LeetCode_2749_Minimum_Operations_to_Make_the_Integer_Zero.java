class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try all possible values of k from 1 to 60
        // (k represents the number of operations)
        for(int k = 1; k <= 60; k++) {
            // Calculate the result after subtracting num2 k times from num1
            // Use long to avoid integer overflow
            long x = 1L * num1 - 1L * num2 * k;

            // If x is less than k, it's impossible to split x into k positive integers
            // (since each must be at least 1)
            if(x < k) {
                return -1;
            }

            // Check if x can be represented as the sum of at most k powers of two
            // Long.bitCount(x) gives the number of set bits in x's binary representation
            // If k >= Long.bitCount(x), it's possible
            if(k >= Long.bitCount(x)) {
                return k; // Return the minimum k found
            }
        }
        // If no valid k is found in the range, return -1
        return -1;
    }
}
