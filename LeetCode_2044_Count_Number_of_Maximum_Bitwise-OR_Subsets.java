class Solution {
    // Main function to count the number of subsets with maximum bitwise OR
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0; // This will store the maximum possible OR value
        
        // Calculate the maximum OR by OR-ing all elements together
        for (int num : nums) {
            maxOR |= num;
        }
        
        // Start the backtracking process from index 0 and currentOR 0
        return backtrack(nums, maxOR, 0, 0);
    }

    // Helper function to recursively count valid subsets
    private int backtrack(int[] nums, int maxOR, int index, int currentOR) {
        // Base case: if we've considered all elements
        if (index == nums.length) {
            // If the OR of the current subset equals maxOR, count it as 1, else 0
            return currentOR == maxOR ? 1 : 0;
        }
        
        // Optimization: if currentOR already equals maxOR,
        // all combinations of the remaining elements will also have maxOR
        if (currentOR == maxOR) {
            // There are 2^(nums.length - index) possible subsets from here
            return 1 << (nums.length - index);
        }
        
        // Recursive case:
        // 1. Include nums[index] in the subset (OR it with currentOR)
        // 2. Exclude nums[index] from the subset (keep currentOR unchanged)
        return backtrack(nums, maxOR, index + 1, currentOR | nums[index]) +
               backtrack(nums, maxOR, index + 1, currentOR);
    }
}
