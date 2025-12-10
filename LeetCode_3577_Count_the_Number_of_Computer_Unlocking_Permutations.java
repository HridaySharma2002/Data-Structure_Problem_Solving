class Solution {
    public int countPermutations(int[] complexity) {
        // Define the modulo constant as 1e9 + 7 to avoid integer overflow in large calculations
        int MOD = (int)1e9 + 7;

        // Store the first element of the complexity array
        int first = complexity[0];

        // Check if all subsequent elements are strictly greater than the first element
        for (int i = 1; i < complexity.length; i++) {
            // If any element is less than or equal to the first, return 0 (no valid permutations)
            if (complexity[i] <= first) {
                return 0;
            }
        }

        // Initialize a variable to compute factorial modulo MOD
        long fact = 1;

        // Calculate (n-2)! where n is the length of the array, since the first two elements are fixed
        for (int i = 2; i < complexity.length; i++) {
            fact = (fact * i) % MOD; // Multiply and take modulo at each step to prevent overflow
        }

        // Return the result as an integer
        return (int)fact;
    }
}
