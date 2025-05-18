class Solution {
    public int[] buildArray(int[] nums) {
        // Create a new array to hold the result
        int result[] = new int[nums.length];
        
        // Iterate through each index of the input array
        for (int i = 0; i < nums.length; i++) {
            // Set the value of result at index i to the value at the index specified by nums[i]
            result[i] = nums[nums[i]];
        }
        
        // Return the newly constructed array
        return result;
    }
}
