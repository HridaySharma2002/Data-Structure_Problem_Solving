class Solution {
    public int minimumOperations(int[] nums) {
        // Create an array to count occurrences of numbers (1 to 100)
        int map[] = new int[101];

        // Iterate through the array from the end to the beginning
        for (int i = nums.length - 1; i >= 0; i--) {
            // Increment the count for the current number
            if (++map[nums[i]] > 1) {
                // If the count exceeds 1, it means we found a duplicate
                // Calculate the number of operations needed to remove elements
                return (i + 3) / 3; // Return the ceiling of (i + 1) / 3
            }
        }
        // If no duplicates were found, return 0
        return 0;
    }
}
