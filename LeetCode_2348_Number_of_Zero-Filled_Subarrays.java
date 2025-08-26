class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // 'count' will hold the total number of zero-filled subarrays found
        long count = 0;
        
        // 'streak' keeps track of the current consecutive zeros streak length
        long streak = 0;
        
        // Iterate through each number in the input array
        for (int num : nums) {
            // If the current number is zero, increment the streak by 1
            // Otherwise, reset the streak to zero because the streak is broken
            streak = (num == 0) ? streak + 1 : 0;
            
            // Add the current streak length to the count
            // This works because every new zero extends all previous zero subarrays by one
            count += streak;
        }
        
        // Return the total count of zero-filled subarrays
        return count;
    }
}
