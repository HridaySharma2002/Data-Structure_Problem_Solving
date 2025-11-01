class Solution {
    // Method to calculate the running sum of the input array
    public int[] runningSum(int[] nums) {
        // Create a new array to store the running sums, same length as input
        int result[] = new int[nums.length];
        
        // Initialize the first element of result with the first element of nums
        result[0] = nums[0];
        
        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Each element in result is the sum of the previous running sum and the current nums element
            result[i] = result[i - 1] + nums[i];
        }
        
        // Return the array containing the running sums
        return result;
    }
}
