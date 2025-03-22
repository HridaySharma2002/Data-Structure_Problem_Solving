class Solution {
    public int[] sortedSquares(int[] nums) {
        // Create an array to hold the squared values
        int result[] = new int[nums.length];
        // Initialize two pointers: left starting at the beginning and right at the end of the array
        int left = 0;
        int right = nums.length - 1;

        // Iterate from the end of the result array to the beginning
        for (int i = nums.length - 1; i >= 0; i--) {
            // Compare the absolute values of the elements at the left and right pointers
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                // If the left element's absolute value is greater, square it and place it in the result
                result[i] = nums[left] * nums[left];
                // Move the left pointer to the right
                left++;
            } else {
                // Otherwise, square the right element and place it in the result
                result[i] = nums[right] * nums[right];
                // Move the right pointer to the left
                right--;
            }
        }
        // Return the result array containing the squares in sorted order
        return result;
    }
}
