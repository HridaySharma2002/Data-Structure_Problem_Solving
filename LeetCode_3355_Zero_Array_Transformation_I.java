class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // Get the length of the nums array
        int n = nums.length;
        
        // Initialize a difference array of size n + 1 to handle range updates
        int d[] = new int[n + 1];
        
        // Step 1: Populate the difference array based on the queries
        for (var q : queries) {
            int l = q[0]; // Start index of the range
            int r = q[1]; // End index of the range
            
            // Increment the start of the range in the difference array
            d[l]++;
            
            // Decrement the position right after the end of the range
            // This marks the end of the decrement effect
            if (r + 1 < n) {
                d[r + 1]--;
            }
        }

        // Step 2: Calculate the cumulative sum of operations and check against nums
        for (int i = 0, s = 0; i < n; i++) {
            // Update the cumulative sum of operations available at index i
            s += d[i];
            
            // Check if the current element in nums can be reduced to zero
            if (nums[i] > s) {
                return false; // If not enough operations, return false
            }
        }

        // If all elements can be reduced to zero, return true
        return true;
    }
}
