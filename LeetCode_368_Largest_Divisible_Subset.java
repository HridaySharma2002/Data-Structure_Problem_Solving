class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Check if the input array is empty
        if (nums.length == 0) {
            return new ArrayList<>(); // Return an empty list if there are no elements
        }

        Arrays.sort(nums);
        int n = nums.length; // Get the length of the input array
        int[] dp = new int[n]; // Array to store the size of the largest divisible subset ending at each index
        int[] prev = new int[n]; // Array to store the previous index in the subset for reconstruction
        int maxSize = 0; // Variable to track the maximum size of the divisible subset found
        int maxIndex = -1; // Variable to track the index of the last element in the largest subset

        // Initialize dp and prev arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each number can form a subset of size 1 (itself)
            prev[i] = -1; // Initialize previous index to -1 (no previous element)
        }

        // Build the dp and prev arrays
        for (int i = 0; i < n; i++) { // Start from the first element
            for (int j = 0; j < i; j++) { // Check all previous elements
                // Check if nums[i] is divisible by nums[j] and if it can form a larger subset
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; // Update the size of the subset ending at i
                    prev[i] = j; // Update the previous index to j
                }
            }

            // Update maxSize and maxIndex if a larger subset is found
            if (dp[i] > maxSize) {
                maxSize = dp[i]; // Update the maximum size
                maxIndex = i; // Update the index of the last element in the largest subset
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>(); // List to store the result subset
        while (maxIndex != -1) { // Backtrack from the last index
            result.add(nums[maxIndex]); // Add the current element to the result
            maxIndex = prev[maxIndex]; // Move to the previous index
        }

        // Sort the result to maintain the order of elements
        Collections.reverse(result);
        return result; // Return the largest divisible subset
    }
}
