class Solution {
    public int minOperations(int[] nums, int k) {
        int operations = 0; // Initialize the count of operations needed
        boolean impossible = false; // Flag to check if making all elements equal to k is impossible

        // Check if any number in the array is less than k
        for (int num : nums) {
            if (num < k) {
                impossible = true; // If any number is less than k, it's impossible to make all equal to k
                break; // Exit the loop early if we find such a number
            }
        }

        // If it's impossible, return -1
        if (impossible) {
            return -1; 
        }

        // Array to track seen numbers greater than k
        boolean seen[] = new boolean[101]; // Since nums[i] <= 100, we can use a boolean array of size 101
        for (int num : nums) {
            // Count unique numbers greater than k
            if (num > k && !seen[num]) {
                operations++; // Increment operations for each unique number greater than k
                seen[num] = true; // Mark this number as seen
            }
        }

        return operations; // Return the total number of operations needed
    }
}
