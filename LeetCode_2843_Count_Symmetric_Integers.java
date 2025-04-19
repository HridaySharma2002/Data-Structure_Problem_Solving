class Solution {
    // Method to count symmetric integers in the range [low, high]
    public int countSymmetricIntegers(int low, int high) {
        int count = 0; // Initialize count of symmetric integers

        // Iterate through each integer in the specified range
        for (int i = low; i <= high; i++) {
            // Check if the number has an even number of digits
            if (is_even_digit_count(i)) {
                int sum1 = 0; // Sum of the first half of digits
                int sum2 = 0; // Sum of the second half of digits
                int num = i; // Store the current number
                int len = get_digit_count(num); // Get the number of digits
                int mid = len / 2; // Calculate the midpoint

                // Calculate the sum of the first half of the digits
                for (int j = 0; j < mid; j++) {
                    sum1 += num % 10; // Add the last digit to sum1
                    num /= 10; // Remove the last digit
                }

                // Calculate the sum of the second half of the digits
                for (int j = 0; j < mid; j++) {
                    sum2 += num % 10; // Add the last digit to sum2
                    num /= 10; // Remove the last digit
                }

                // Check if the two sums are equal
                if (sum1 == sum2) {
                    count++; // Increment count if the sums are equal
                }
            }
        }
        return count; // Return the total count of symmetric integers
    }

    // Helper method to check if a number has an even number of digits
    public boolean is_even_digit_count(int num) {
        int count = 0; // Initialize digit count
        // Count the number of digits in the number
        while (num > 0) {
            count++;
            num /= 10; // Remove the last digit
        }
        return count % 2 == 0; // Return true if the count is even
    }

    // Helper method to get the digit count of a number
    public int get_digit_count(int num) {
        int count = 0; // Initialize digit count
        // Count the number of digits in the number
        while (num > 0) {
            count++;
            num /= 10; // Remove the last digit
        }
        return count; // Return the total digit count
    }
}
