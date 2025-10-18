class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // Sort the array to process numbers in increasing order
        Arrays.sort(nums);

        int result = 0; // To count the maximum number of distinct elements
        int prev = Integer.MIN_VALUE; // Tracks the last assigned distinct value

        // Iterate through each number in the sorted array
        for (int num : nums) {
            // Calculate the smallest possible value for this number
            // It must be at least prev + 1 (to ensure distinctness)
            // and at least num - k (to stay within the allowed range)
            int l = Math.max(num - k, prev + 1);

            // Check if this value is within the allowed range for the current number
            if (l <= num + k) {
                prev = l; // Assign this value as the new distinct value
                result++; // Increment the count of distinct elements
            }
        }
        // Return the total number of distinct elements assigned
        return result;
    }
}
