class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0; // Initialize a variable to store the sum of all elements in nums
        
        // Iterate through each number in the nums array
        for (int num : nums) {
            sum += num; // Add the current number to the sum
        }
        
        // Return the remainder when sum is divided by k
        // This gives the minimum number of operations needed to make the sum divisible by k
        return sum % k;
    }
}
