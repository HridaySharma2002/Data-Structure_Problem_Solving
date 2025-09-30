class Solution {
    public int triangularSum(int[] nums) {
        // Outer loop controls the size of the current row, starting from the full length down to 2
        for(int i = nums.length; i > 1; i--) {
            // Inner loop calculates the new values for the next row by summing adjacent elements modulo 10
            for(int j = 0; j < i - 1; j++) {
                // Update nums[j] to be the sum of nums[j] and nums[j+1], modulo 10
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
            // After each iteration, the effective length of the array reduces by 1
        }
        // After all iterations, the first element contains the triangular sum
        return nums[0];
    }
}
