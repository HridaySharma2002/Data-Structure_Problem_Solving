class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;               // Get the length of the input array
        int result[] = new int[n];         // Initialize the result array of the same length
        
        // Iterate through each index of the input array
        for (int i = 0; i < n; i++) {
            // Calculate the target index by adding nums[i] to current index i
            // Use modulo operation twice to handle negative values and wrap around circularly
            int targetIndex = ((i + nums[i]) % n + n) % n;
            
            // Assign the value at the target index in nums to the current index in result
            result[i] = nums[targetIndex];
        }
        
        // Return the transformed array
        return result;
    }
}
