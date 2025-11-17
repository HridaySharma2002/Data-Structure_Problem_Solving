class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastindex = -1; // Initialize lastindex to -1 to indicate no '1' has been found yet
        
        // Iterate through the array nums
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) { // When we find a '1'
                // If this is not the first '1' and the distance between current and last '1' is less than k
                if (lastindex != -1 && i - lastindex - 1 < k) {
                    return false; // Return false because '1's are too close
                }
                lastindex = i; // Update lastindex to current index of '1'
            }
        }
        
        // If loop completes without returning false, all '1's are at least k places apart
        return true;
    }
}
