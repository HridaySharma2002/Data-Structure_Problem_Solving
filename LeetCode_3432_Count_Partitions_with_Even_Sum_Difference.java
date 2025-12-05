class Solution {
    public int countPartitions(int[] nums) {
        int total = 0; // Initialize total sum of all elements

        // Calculate the total sum of the array
        for (int num : nums) {
            total += num;
        }

        int leftsum = 0; // Sum of elements on the left side of the partition
        int count = 0;   // Number of valid partitions

        // Iterate through the array, stopping before the last element to ensure both parts are non-empty
        for (int i = 0; i < nums.length - 1; i++) {
            leftsum += nums[i]; // Add current element to leftsum
            int rightsum = total - leftsum; // Calculate the sum of the right part

            // Check if both leftsum and rightsum have the same parity (both even or both odd)
            if ((leftsum % 2) == (rightsum % 2)) {
                count++; // If parity matches, increment the count
            }
        }
        return count; // Return the total number of valid partitions
    }
}
