class Solution {
    public int differenceOfSums(int n, int m) {
        // If n is 0, return 0 as there are no numbers to consider
        if (n == 0) {
            return 0;
        }

        int num1 = 0; // Initialize sum for numbers not divisible by m
        int num2 = 0; // Initialize sum for numbers divisible by m

        // Iterate through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if the current number is divisible by m
            if (i % m == 0) {
                num2 += i; // Add to num2 if divisible by m
            } else {
                num1 += i; // Add to num1 if not divisible by m
            }
        }

        // Return the difference between the two sums
        return num1 - num2; // num1 is the sum of non-divisible numbers, num2 is the sum of divisible numbers
    }
}
