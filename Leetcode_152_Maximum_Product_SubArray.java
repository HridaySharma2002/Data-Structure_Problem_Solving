class Solution {
    public int maxProduct(int[] nums) {
        // Initialize variables to track the maximum product and the current products
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // If the current number is negative, swap the max and min
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            // Update the current maximum and minimum products
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            
            // Update the global maximum product
            maxProduct = Math.max(maxProduct, currentMax);
        }
        
        return maxProduct;
    }
}
