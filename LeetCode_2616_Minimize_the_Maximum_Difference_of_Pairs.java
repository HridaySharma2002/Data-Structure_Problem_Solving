class Solution {
    public int minimizeMax(int[] nums, int p) {
        // If no pairs are to be formed, the minimum maximum difference is 0
        if (p == 0) {
            return 0;
        }

        // Sort the array to facilitate pairing of elements with minimal differences
        Arrays.sort(nums);
        
        // Get the length of the sorted array
        int n = nums.length;
        
        // Initialize left and right bounds for binary search
        int left = 0; // Minimum possible difference
        int right = nums[n - 1] - nums[0]; // Maximum possible difference (max - min)

        // Perform binary search to find the minimized maximum difference
        while (left < right) {
            // Calculate the mid-point of the current search range
            int mid = left + (right - left) / 2;
            int pairs = 0; // Count of pairs that can be formed with the current max difference

            // Iterate through the sorted array to count valid pairs
            for (int i = 1; i < n; i++) {
                // Check if the difference between adjacent elements is within the allowed max difference (mid)
                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++; // A valid pair is formed
                    i++; // Move to the next element to avoid reusing it in a pair
                }
            }

            // If the number of pairs formed is greater than or equal to p, try for a smaller max difference
            if (pairs >= p) {
                right = mid; // Adjust the right bound to mid
            } else {
                // If not enough pairs can be formed, increase the minimum possible difference
                left = mid + 1; // Adjust the left bound to mid + 1
            }
        }

        // Return the minimized maximum difference
        return left;
    }
}
