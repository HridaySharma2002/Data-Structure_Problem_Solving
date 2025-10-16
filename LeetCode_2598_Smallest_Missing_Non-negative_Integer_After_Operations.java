class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int result = 0; // This will store the answer: the smallest missing non-negative integer (MEX)
        int[] rem = new int[value]; // Array to count how many numbers have each possible remainder modulo 'value'

        // Count the frequency of each remainder class
        for (int num : nums) {
            // Calculate non-negative remainder for both positive and negative numbers
            int r = ((num % value) + value) % value;
            rem[r]++; // Increment the count for this remainder
        }

        // Try to build the sequence [0, 1, 2, ...] as far as possible using available remainders
        // For each result, check if there's a number with remainder (result % value) left
        while (rem[result % value]-- > 0) {
            result++; // If available, use it and move to the next integer
        }

        // The first integer that cannot be formed is the answer (maximum possible MEX)
        return result;
    }
}
