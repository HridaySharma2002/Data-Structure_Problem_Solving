class Solution {
    // Main method to initiate the XOR sum calculation
    public int subsetXORSum(int[] nums) {
        return xor_sum(nums, 0, 0); // Start recursion with index 0 and current XOR as 0
    }

    // Recursive method to calculate the sum of XORs of all subsets
    public int xor_sum(int[] nums, int index, int current_xor) {
        // Base case: if we've considered all elements
        if (index == nums.length) {
            return current_xor; // Return the current XOR total for this subset
        }

        // Include the current element in the XOR calculation
        int include_xor_sum = xor_sum(nums, index + 1, current_xor ^ nums[index]);
        
        // Exclude the current element from the XOR calculation
        int exclude_xor_sum = xor_sum(nums, index + 1, current_xor);

        // Return the sum of both cases: including and excluding the current element
        return include_xor_sum + exclude_xor_sum;
    }
}
