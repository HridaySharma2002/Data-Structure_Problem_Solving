class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0; // Initialize the count of interesting subarrays
        int n = nums.size(); // Get the size of the input list
        int[] prefixSum = new int[n + 1]; // Array to store prefix sums
        HashMap<Integer, Long> countMap = new HashMap<>(); // Map to count occurrences of mod values
        
        // Initialize the countMap with the base case
        countMap.put(0, 1L); // There is one way to have a prefix sum of 0 (no elements)

        // Iterate through the nums list to calculate prefix sums
        for (int i = 0; i < n; i++) {
            // Check if the current number satisfies the condition
            if (nums.get(i) % modulo == k) {
                prefixSum[i + 1] = prefixSum[i] + 1; // Increment the prefix sum
            } else {
                prefixSum[i + 1] = prefixSum[i]; // Carry forward the previous prefix sum
            }

            // Calculate the current mod value of the prefix sum
            int currentMod = prefixSum[i + 1] % modulo;
            // Calculate the target mod value we need to find in the map
            int targetMod = (currentMod - k + modulo) % modulo;

            // If the target mod exists in the map, add its count to the result
            count += countMap.getOrDefault(targetMod, 0L);
            
            // Update the countMap with the current mod value
            countMap.put(currentMod, countMap.getOrDefault(currentMod, 0L) + 1);
        }
        
        return count; // Return the total count of interesting subarrays
    }
}
