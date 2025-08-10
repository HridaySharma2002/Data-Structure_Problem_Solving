class Solution {
    public int longestSubarray(int[] nums) {
        // Edge case: if the array is empty, return 0
        if(nums.length == 0){
            return 0;
        }

        // Step 1: Find the maximum value in the array
        int maxval = 0;
        for(int num : nums){
            if(num > maxval){
                maxval = num;
            }
        }

        // Step 2: Find the length of the longest contiguous subarray where every element equals maxval
        int maxlen = 0;   // To keep track of the maximum length found so far
        int currlen = 0;  // To count the current streak of maxval elements

        for(int num : nums){
            if(num == maxval){
                // If current number equals maxval, increment current streak
                currlen++;
            } else {
                // If not, update maxlen if needed and reset current streak
                maxlen = Math.max(maxlen, currlen);
                currlen = 0;
            }
        }

        // After the loop, check one last time in case the longest streak is at the end
        return Math.max(maxlen, currlen);
    }
}
