class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];  // dp[i] will store the maximum energy sum starting from index i
        int result = Integer.MIN_VALUE;  // Initialize result to the smallest integer value
        
        // Iterate from the end of the array to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // Calculate dp[i] as current energy plus dp[i+k] if within bounds, else just current energy
            dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0);
            // Update result if dp[i] is greater than current result
            result = Math.max(result, dp[i]);
        }
        
        // Return the maximum energy sum found
        return result;
    }
}
