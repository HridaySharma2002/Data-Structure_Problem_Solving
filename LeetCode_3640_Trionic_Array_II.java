class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // Initialize min_val to the smallest possible long value to track max sums
        long min_val = Long.MIN_VALUE;
        // Result will hold the maximum sum found for the "trionic" subarray
        long result = min_val;

        // Iterate through each element as a potential center of the trionic subarray
        for (int i = 0; i < n; i++) {
            int left_ind = i;
            int right_ind = i;
            // Start center_sum with the current element
            long center_sum = nums[left_ind];

            // Expand right while the next element is strictly decreasing
            while (right_ind + 1 < n && nums[right_ind + 1] < nums[right_ind]) {
                center_sum += (long) nums[right_ind + 1];
                right_ind++;
            }

            // If no decreasing sequence found (center is a single element), skip
            if (right_ind == left_ind) {
                continue;
            }

            // Mark the end of the center decreasing sequence
            int center_end = right_ind;

            // Variables to track sums and max sums on left and right sides
            long left_part_sum = 0;
            long right_part_sum = 0;
            long max_left = min_val;
            long max_right = min_val;

            // Expand left while the previous element is strictly increasing
            while (left_ind - 1 >= 0 && nums[left_ind - 1] < nums[left_ind]) {
                left_part_sum += (long) nums[left_ind - 1];
                max_left = Math.max(max_left, left_part_sum);
                left_ind--;
            }

            // If no increasing sequence found on the left side, skip
            if (left_ind == i) {
                continue;
            }

            // Expand right while the next element is strictly increasing
            while (right_ind + 1 < n && nums[right_ind + 1] > nums[right_ind]) {
                right_part_sum += (long) nums[right_ind + 1];
                max_right = Math.max(max_right, right_part_sum);
                right_ind++;
            }

            // If no increasing sequence found on the right side, skip
            if (right_ind == center_end) {
                continue;
            }

            // Move i to the end of the right increasing sequence to avoid redundant checks
            i = right_ind - 1;

            // Update the result with the maximum sum of left + center + right parts
            result = Math.max(result, max_left + max_right + center_sum);
        }

        // Return the maximum trionic sum found
        return result;
    }
}
