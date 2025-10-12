class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Initialize the result array with the same length as nums
        int result[] = new int[nums.length];
        
        // 'curr' will hold the running product as we iterate through nums
        int curr = 1;
        
        // Fill the result array with 1s because we'll multiply values into it
        Arrays.fill(result, 1);
        
        // First pass: calculate the product of all elements to the left of each index
        for (int i = 0; i < nums.length; i++) {
            result[i] *= curr;  // multiply by product of all elements before i
            curr *= nums[i];    // update curr to include nums[i]
        }
        
        // Reset curr to 1 for the second pass
        curr = 1;
        
        // Second pass: calculate the product of all elements to the right of each index
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= curr;  // multiply by product of all elements after i
            curr *= nums[i];    // update curr to include nums[i]
        }
        
        // Return the final array where each element is the product of all other elements
        return result;
    }
}
