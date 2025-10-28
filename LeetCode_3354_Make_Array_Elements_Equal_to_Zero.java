class Solution {
    public int countValidSelections(int[] nums) {
        int prefix = 0;      // Running prefix sum of elements processed so far
        int count = 0;       // Counter to accumulate the result based on zeros and prefix sums
        int sum = 0;         // Total sum of all elements in the array

        // Calculate the total sum of the array elements
        for (int num : nums) {
            sum += num;
        }

        // Iterate through the array again to process prefix sums and zeros
        for (int num : nums) {
            prefix += num;   // Update prefix sum by adding current element

            // When the current element is zero, calculate a "move" value
            if (num == 0) {
                // Calculate how close the doubled prefix sum is to the total sum
                // 2 * prefix - sum measures the difference from half the total sum
                // Math.abs(...) gets the absolute difference
                // 2 - difference gives a value that rewards closeness to half the sum
                // Math.max(..., 0) ensures move is never negative
                int move = Math.max(2 - Math.abs(2 * prefix - sum), 0);

                // Add the move value to the count
                count += move;
            }
        }

        // Return the accumulated count after processing all elements
        return count;
    }
}
