class Solution {
    public int findNumbers(int[] nums) {
        int count = 0; // Initialize a counter for numbers with even digits
        for (int num : nums) {
            // Check if the number of digits is even
            if (String.valueOf(num).length() % 2 == 0) {
                count++; // Increment the count if the condition is met
            }
        }
        return count; // Return the total count
    }
}
