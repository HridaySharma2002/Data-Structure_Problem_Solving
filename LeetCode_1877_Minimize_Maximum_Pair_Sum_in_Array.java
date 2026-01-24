class Solution {
    public int minPairSum(int[] nums) {
        // Sort the array to pair the smallest and largest elements
        Arrays.sort(nums);

        // Initialize max_sum to keep track of the maximum pair sum found
        int max_sum = 0;

        // Two pointers: left starts at the beginning, right at the end of the array
        int left = 0;
        int right = nums.length - 1;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the sum of the current pair
            int current_sum = nums[left] + nums[right];

            // Update max_sum if the current pair sum is greater than the previous max
            max_sum = Math.max(max_sum, current_sum);

            // Move left pointer forward and right pointer backward to consider next pair
            left++;
            right--;
        }

        // Return the minimized maximum pair sum after pairing all elements
        return max_sum;
    }
}
