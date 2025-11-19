class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Sort the array in ascending order so we can efficiently check for the presence of 'original'
        Arrays.sort(nums); // Uses Dual-Pivot Quicksort for primitive int arrays [[2]]

        // Iterate through each element in the sorted array
        for(int i = 0; i < nums.length; i++) {
            // If the current element equals 'original', double the value of 'original'
            if(nums[i] == original) {
                original = 2 * original;
            }
            // If nums[i] > original, we could break early since the array is sorted,
            // but the current logic checks all elements for completeness.
        }

        // Return the final value of 'original' after processing the array
        return original;
    }
}
