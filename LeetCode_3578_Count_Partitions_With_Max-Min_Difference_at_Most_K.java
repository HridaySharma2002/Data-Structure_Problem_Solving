class Solution {
    public int countPartitions(int[] nums, int k) {
        // The modulo value to avoid integer overflow
        int MOD = (int)1e9 + 7;
        int n = nums.length;
        
        // dp[i]: number of ways to partition the first i elements
        // dp[0] = 1: base case, empty array has one valid partition (no segments)
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        // Deques to maintain indices of max and min elements in the current window
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        
        // sum: cumulative sum of dp values for the current window
        long sum = 0;
        
        // left: left boundary of the sliding window
        int left = 0;
        
        // Iterate through the array with right as the end of the current segment
        for (int right = 0; right < n; right++) {
            // Maintain decreasing order in max deque (for max in window)
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[right]) {
                max.pollLast();
            }
            // Maintain increasing order in min deque (for min in window)
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[right]) {
                min.pollLast();
            }
            // Add current index to both deques
            max.add(right);
            min.add(right);
            
            // Shrink window from the left if max - min > k
            while (nums[max.peek()] - nums[min.peek()] > k) {
                // If the leftmost index is at the front of max deque, remove it
                if (max.peek() == left) {
                    max.poll();
                }
                // If the leftmost index is at the front of min deque, remove it
                if (min.peek() == left) {
                    min.poll();
                }
                // Remove dp[left] from sum as window is moving right
                sum = (sum - dp[left] + MOD) % MOD;
                left++;
            }
            
            // Add dp[right] to sum for the new window
            sum = (sum + dp[right]) % MOD;
            // dp[right + 1]: number of ways to partition up to right+1
            dp[right + 1] = sum;
        }
        
        // The answer is the number of ways to partition the whole array
        return (int) dp[n];
    }
}
