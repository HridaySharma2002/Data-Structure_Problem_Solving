class Solution {
    public int minimumOneBitOperations(int n) {
        // Initialize result to 0.
        // This variable will hold the minimum number of operations required.
        int result = 0;

        // Loop until n becomes 0
        while (n > 0) {
            // XOR the current result with n.
            // This step accumulates the Gray code representation of n,
            // which corresponds to the minimum operations needed.
            result ^= n;

            // Right shift n by 1 bit to process the next higher bit in the next iteration.
            n >>= 1;
        }

        // Return the accumulated result which is the minimum number of operations.
        return result;
    }
}
