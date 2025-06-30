class Solution {

    // Optimized Approach
    // Combination of Dynamic Programming and Binary Search
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; // Get the length of the input array
        if (n == 0) { // If the array is empty, return 0
            return 0;
        }
        
        int tails[] = new int[n]; // Array to store the smallest tail of all increasing subsequences
        int size = 0; // Variable to keep track of the size of the longest increasing subsequence found

        // Iterate through each number in the input array
        for (int num : nums) {
            int left = 0; // Left pointer for binary search
            int right = size; // Right pointer for binary search
            
            // Perform binary search to find the insertion point for num
            while (left < right) {
                int mid = left + (right - left) / 2; // Calculate the mid index
                if (tails[mid] < num) { // If the mid value is less than num
                    left = mid + 1; // Move left pointer to mid + 1
                } else {
                    right = mid; // Move right pointer to mid
                }
            }

            // Update the tails array with the current number
            tails[left] = num; 
            // If left equals size, it means we are extending the size of the longest subsequence
            if (left == size) {
                size++; // Increment the size
            }
        }

        return size; // Return the length of the longest increasing subsequence
    }

    /*
    // Dynamic Programming Approach
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; // Get the length of the input array
        if (n == 0) { // If the array is empty, return 0
            return 0;
        }
        
        int dp[] = new int[n]; // Array to store the lengths of the longest increasing subsequences
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Initialize each position to 1 (each element is an increasing subsequence of length 1)
        }

        int maxlength = 1; // Variable to keep track of the maximum length found
        // Build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // If the current number is greater than a previous number
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update dp[i] to the maximum length found
                }
            }
            maxlength = Math.max(dp[i], maxlength); // Update the maximum length found
        }

        return maxlength; // Return the maximum length of the increasing subsequence
    }
    */
}
