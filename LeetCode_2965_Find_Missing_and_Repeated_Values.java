class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;           // Size of the grid (n x n)
        int repeated = -1;             // Variable to store the repeated number
        int missing = -1;              // Variable to store the missing number
        Set<Integer> seen = new HashSet<>();  // Set to track numbers seen so far

        // Traverse the grid to find the repeated number
        for (int[] row : grid) {
            for (int num : row) {
                // Try to add the number to the set
                // If add returns false, number is repeated
                if (!seen.add(num)) {
                    repeated = num;
                }
            }
        }

        // Check for the missing number in the range [1, n*n]
        for (int num = 1; num <= n * n; num++) {
            // If a number is not in the set, it is missing
            if (!seen.contains(num)) {
                missing = num;
                break;  // Stop after finding the missing number
            }
        }

        // Return the repeated and missing numbers as an array
        return new int[]{repeated, missing};
    }
}
