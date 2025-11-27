class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long minprefix[] = new long[k];  // minprefix[mod] stores the minimum prefix sum encountered so far for prefix sums with remainder 'mod' when divided by k
        boolean seen[] = new boolean[k]; // seen[mod] indicates whether we have encountered any prefix sum with remainder 'mod' yet
        long prefixsum = 0;              // running prefix sum of elements processed so far
        long maxsum = Long.MIN_VALUE;    // stores the maximum subarray sum found whose length is divisible by k

        // Initialize for mod = 0: prefix sum 0 (empty prefix) is considered seen with min prefix sum 0
        minprefix[0] = 0;
        seen[0] = true;

        for (int i = 0; i < nums.length; i++) {
            prefixsum += nums[i]; 
            // Calculate mod class for prefix sum ending at index i (length = i+1)
            int mod = ((i + 1) % k + k) % k; // ensure non-negative modulo

            // If we have seen a prefix sum with the same mod before,
            // the subarray between that prefix and current prefix has length divisible by k
            if (seen[mod]) {
                long candidate = prefixsum - minprefix[mod]; // potential max subarray sum
                maxsum = Math.max(maxsum, candidate);        // update maxsum if candidate is larger
            }

            // Update the minimum prefix sum for this mod class if this prefix sum is smaller
            // or if this mod class hasn't been seen before
            if (!seen[mod] || prefixsum < minprefix[mod]) {
                minprefix[mod] = prefixsum;
                seen[mod] = true;
            }
        }
        return maxsum;
    }
}
