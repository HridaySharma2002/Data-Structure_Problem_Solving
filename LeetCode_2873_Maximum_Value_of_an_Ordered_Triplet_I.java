class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length; // Get the length of the input array
        long maxValue = 0; // Initialize maxValue to 0, which will hold the maximum triplet value

        // Arrays to store the maximum values to the left and right of each index
        long maxleft[] = new long[n]; // maxleft[i] will hold the max value of nums[0] to nums[i-1]
        long maxright[] = new long[n]; // maxright[i] will hold the max value of nums[i+1] to nums[n-1]

        // Fill maxleft array
        maxleft[0] = Integer.MIN_VALUE; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            // For each index i, store the maximum value from the left side (nums[0] to nums[i-1])
            maxleft[i] = Math.max(maxleft[i - 1], nums[i - 1]);
        }

        // Fill maxright array
        maxright[n - 1] = Integer.MIN_VALUE; // No elements to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            // For each index i, store the maximum value from the right side (nums[i+1] to nums[n-1])
            maxright[i] = Math.max(maxright[i + 1], nums[i + 1]);
        }

        // Calculate the maximum triplet value
        for (int i = 1; i < n - 1; i++) {
            // Calculate the triplet value using the precomputed max values
            long tripletValue = (maxleft[i] - nums[i]) * maxright[i];
            // Update maxValue if the current tripletValue is greater
            maxValue = Math.max(maxValue, tripletValue);
        }

        // Return the maximum triplet value found, or 0 if all values are negative
        return maxValue > 0 ? maxValue : 0;
    }
}
