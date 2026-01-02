class Solution {
    // Method to find the repeated element
    public int repeatedNTimes(int[] nums) {
        // Check if the first and last elements are the same
        // This handles cases where the repeated element is at both ends
        if(nums[0]==nums[nums.length-1]){
            return nums[0];
        }
        // Iterate through the array, but stop two elements before the end
        for(int i=0;i<nums.length-2;i++){
            // Check if the current element is equal to the next one or the one after next
            // This works because the repeated element must appear at least twice and close together
            if(nums[i]==nums[i+1]||nums[i]==nums[i+2]){
                return nums[i];
            }
        }
        // If not found in the above checks, the repeated element must be at the end
        return nums[nums.length-1];
    }
}
