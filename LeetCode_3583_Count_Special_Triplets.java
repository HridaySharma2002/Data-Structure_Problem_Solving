class Solution {
    public int specialTriplets(int[] nums) {
        // Define the modulo constant as 1e9+7 to avoid integer overflow in the result
        int MOD = (int)1e9 + 7;
        // Set the maximum possible value for elements in nums (as per constraints)
        int n = (int)1e5 + 1;
        // Variable to store the final result (number of special triplets)
        long result = 0;
        // Array to count the frequency of each number in nums
        int[] hash = new int[n];
        // Array to keep track of the count of each number seen so far (prefix count)
        int[] prev = new int[n];

        // Count the frequency of each number in nums
        for (int num : nums) {
            hash[num]++;
        }

        // Iterate through nums, considering each element (except first and last) as the middle of a triplet
        for (int i = 1; i < nums.length - 1; i++) {
            // Update prefix count for the previous number
            prev[nums[i - 1]]++;
            // Current middle element of the triplet
            int j = nums[i];
            // The value we are looking for in the triplet (k = 2 * j)
            int k = 2 * j;
            // Check if k is within bounds
            if (k < n) {
                // Calculate the number of valid triplets:
                // prev[k]: number of k's before index i
                // hash[k] - prev[k]: number of k's after index i
                // (j == 0 ? 1 : 0): avoid counting the current element if j == 0
                result += (long)prev[k] * (hash[k] - prev[k] - (j == 0 ? 1 : 0));
            }
        }
        // Return the result modulo MOD
        return (int)(result % MOD);
    }
}
