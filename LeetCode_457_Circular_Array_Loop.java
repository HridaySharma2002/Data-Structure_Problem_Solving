class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // Iterate over each index as a potential start of a cycle
        for (int i = 0; i < nums.length; i++) {
            // Determine the direction of movement from this index (true if forward, false if backward)
            boolean isForward = nums[i] > 0;
            
            // Initialize slow and fast pointers to the current index
            int slow = i;
            int fast = i;
            
            // Move slow pointer one step ahead
            slow = findnextindex(nums, isForward, slow);
            // Move fast pointer two steps ahead
            fast = findnextindex(nums, isForward, fast);
            if (fast != -1) {
                fast = findnextindex(nums, isForward, fast);
            }
            
            // Continue moving pointers while they are valid and have not met
            while (slow != -1 && fast != -1 && slow != fast) {
                // Move slow pointer one step
                slow = findnextindex(nums, isForward, slow);
                // Move fast pointer one step
                fast = findnextindex(nums, isForward, fast);
                // Move fast pointer an additional step if still valid
                if (fast != -1) {
                    fast = findnextindex(nums, isForward, fast);
                }
            }
            
            // If slow and fast pointers meet and are valid, a cycle exists
            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        // No cycle found after checking all indices
        return false;
    }
    
    // Helper method to find the next index to move to
    private int findnextindex(int nums[], boolean isForward, int currindex) {
        // Check the direction of the current element
        boolean direction = nums[currindex] >= 0;
        
        // If the direction changes, return -1 indicating invalid move
        if (isForward != direction) {
            return -1;
        }
        
        // Calculate the next index with wrap-around using modulo
        int nextindex = (currindex + nums[currindex]) % nums.length;
        
        // If nextindex is negative, wrap it around to the end of the array
        if (nextindex < 0) {
            nextindex += nums.length;
        }
        
        // If next index is the same as current, it means a self-loop, which is invalid
        if (nextindex == currindex) {
            return -1;
        }
        
        // Return the valid next index
        return nextindex;
    }
}
