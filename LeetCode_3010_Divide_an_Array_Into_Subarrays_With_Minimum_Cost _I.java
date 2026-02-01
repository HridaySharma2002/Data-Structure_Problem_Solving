class Solution {
    public int minimumCost(int[] nums) {
        // Initialize min and second_min to the largest possible integer value
        // so any number in the array will be smaller and replace these values.
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;

        // Start from index 1 because index 0 is used separately in the return statement
        for (int i = 1; i < nums.length; i++) {
            // If current number is smaller than min,
            // update second_min to the old min and min to current number
            if (nums[i] < min) {
                second_min = min;
                min = nums[i];
            } 
            // Otherwise, if current number is smaller than second_min,
            // update second_min to current number
            else if (nums[i] < second_min) {
                second_min = nums[i];
            }
        }

        // Return the sum of the first element and the two smallest elements found
        return nums[0] + min + second_min;
    }
}
