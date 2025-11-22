class Solution {
    public int minimumOperations(int[] nums) {
        // Initialize the result variable to store the count of operations needed
        int result = 0;
        
        // Iterate through each number in the input array
        for (int num : nums) {
            // Check if the current number is NOT divisible by 3
            if (num % 3 != 0) {
                // If not divisible by 3, increment the result (operation needed)
                result++;
            }
        }
        
        // Return the total number of operations required
        return result;
    }
}
