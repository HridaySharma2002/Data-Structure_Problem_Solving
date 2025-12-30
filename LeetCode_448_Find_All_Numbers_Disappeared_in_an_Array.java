class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(); // List to store missing numbers

        // Step 1: Mark indices corresponding to numbers present in the array
        for (int num : nums) {
            // Calculate index for the current number (1-based to 0-based)
            int index = Math.abs(num) - 1;

            // Mark the number at this index as negative to indicate presence
            // Use Math.abs to avoid double negation issues
            nums[index] = -Math.abs(nums[index]);
        }

        // Step 2: Collect indices which are still positive
        // These indices + 1 correspond to numbers missing from the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // If value is positive, number (i+1) was not found in the array
                result.add(i + 1);
            }
        }

        return result; // Return the list of missing numbers
    }
}
