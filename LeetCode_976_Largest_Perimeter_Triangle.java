class Solution {
    public int largestPerimeter(int[] nums) {
        // Sort the array in ascending order to easily check the triangle condition
        Arrays.sort(nums);
        
        // Iterate from the largest element down to the third element
        // We start from the end because the largest perimeter will come from the largest sides
        for(int i = nums.length - 1; i >= 2; i--) {
            // Check if the sum of the two smaller sides is greater than the largest side
            // This is the triangle inequality condition
            if(nums[i - 1] + nums[i - 2] > nums[i]) {
                // If condition is met, return the perimeter of the triangle
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        
        // If no valid triangle can be formed, return 0
        return 0;
    }
}
