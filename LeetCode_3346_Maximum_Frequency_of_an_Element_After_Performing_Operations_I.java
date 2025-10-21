class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // Find the maximum value in nums to determine the size of our frequency array
        int max = Arrays.stream(nums).max().getAsInt();
        // The frequency and prefix arrays need to cover all possible values after up to k operations
        int n = max + k + 2;
        
        // Frequency array: freq[x] = number of times x appears in nums
        int[] freq = new int[n];
        for (int num : nums) {
            freq[num]++;
        }
        
        // Prefix sum array: pre[i] = total count of numbers <= i
        int[] pre = new int[n];
        pre[0] = freq[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + freq[i];
        }
        
        int result = 0; // To store the maximum frequency found
        
        // Try every possible target value i (could be any value in the range)
        for (int i = 0; i < n; i++) {
            // If i is not present in nums and we have no operations left, skip
            if (freq[i] == 0 && numOperations == 0) {
                continue;
            }
            // Define the range [l, r] of values that can be converted to i using at most k per operation
            int l = Math.max(0, i - k);
            int r = Math.min(n - 1, i + k);
            
            // Total number of elements in nums within [l, r]
            int tot = pre[r] - (l > 0 ? pre[l - 1] : 0);
            // Number of elements in [l, r] that are NOT already i
            int adj = tot - freq[i];
            // We can convert up to numOperations of these to i, but not more than adj
            int val = freq[i] + Math.min(numOperations, adj);
            // Update result if this is the highest frequency so far
            result = Math.max(result, val);
        }
        // Return the maximum frequency achievable
        return result;
    }
}
