class Solution {
    // Method to count the number of groups with the largest size based on digit sums
    public int countLargestGroup(int n) {
        // Array to hold the sizes of groups based on the sum of digits (maximum sum is 36 for n <= 10^4)
        int groupsizes[] = new int[37];

        // Loop through each number from 1 to n
        for (int i = 1; i <= n; i++) {
            // Calculate the sum of digits for the current number
            int sum = digitsum(i);
            // Increment the count for the corresponding digit sum group
            groupsizes[sum]++;
        }

        // Variable to track the maximum size of any group
        int maxsize = 0;
        // Find the maximum size among all groups
        for (int size : groupsizes) {
            if (size > maxsize) {
                maxsize = size; // Update maxsize if a larger group is found
            }
        }

        // Variable to count how many groups have the largest size
        int count = 0;
        // Count the number of groups that have the maximum size
        for (int size : groupsizes) {
            if (size == maxsize) {
                count++; // Increment count for each group matching maxsize
            }
        }

        // Return the count of groups with the largest size
        return count;
    }

    // Helper method to calculate the sum of digits of a given number
    public int digitsum(int num) {
        int sum = 0; // Initialize sum to 0
        // Loop to extract each digit and add it to sum
        while (num > 0) {
            sum += num % 10; // Add the last digit to sum
            num /= 10; // Remove the last digit
        }
        return sum; // Return the total sum of digits
    }
}
