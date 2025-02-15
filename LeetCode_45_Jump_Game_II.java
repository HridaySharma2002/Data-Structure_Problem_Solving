class Solution {
    public int jump(int[] nums) {
        // Initialize pointers for the current range of jumps
        int left = 0; // Start of the current jump range
        int right = 0; // End of the current jump range
        int jumps = 0; // Counter for the number of jumps made
        
        // Continue until we reach the last index
        while (right < nums.length - 1) {
            int farthest = 0; // Variable to track the farthest index we can reach
            
            // Iterate through the current jump range to find the farthest point
            for (int i = left; i <= right; i++) {
                // Update the farthest index we can reach from the current range
                farthest = Math.max(farthest, i + nums[i]);
            }
            // Move to the next jump range
            left = right + 1; // Update the left pointer to the next range
            right = farthest; // Update the right pointer to the farthest reachable index
            jumps++; // Increment the jump counter
        }
        // Return the total number of jumps made
        return jumps; // Total jumps needed to reach the last index
    }
}
