class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;  // Initialize result to accumulate sum of divisors

        // Iterate through each number in the input array
        for (int i = 0; i < nums.length; i++) {
            // Add the sum of divisors of nums[i] if it has exactly 4 divisors
            result += factors(nums[i]);
        }

        // Return the total sum after processing all numbers
        return result;
    }

    // Helper method to calculate sum of divisors if the number has exactly 4 divisors
    // Returns 0 if the number does not have exactly 4 divisors
    private int factors(int num) {
        int sum = 0;     // Sum of divisor pairs found (excluding 1 and num)
        int count = 0;   // Count of divisor pairs found

        // Check for divisors from 2 up to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {  // If i divides num evenly
                int j = num / i; // Corresponding divisor pair

                // If divisors are equal (perfect square) or more than one pair found,
                // number does not have exactly 4 divisors, so return 0
                if (j == i || count > 0) {
                    return 0;
                }

                // Add both divisors to sum
                sum += i + j;
                count++;  // Increment count of divisor pairs found
            }
        }

        // If no divisor pairs found (other than 1 and num), return 0
        if (count == 0) {
            return 0;
        }

        // Return sum of all divisors: 1 + num + sum of divisor pairs
        return 1 + sum + num;
    }
}
