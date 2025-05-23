class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0; // Initialize sum for the first array
        long sum2 = 0; // Initialize sum for the second array
        int zeroes1 = 0; // Count of zeroes in the first array
        int zeroes2 = 0; // Count of zeroes in the second array

        // Calculate the sum of elements in nums1 and count zeroes
        for (int num : nums1) {
            sum1 += num; // Add each number to sum1
            if (num == 0) {
                zeroes1++; // Increment zeroes1 if the number is zero
            }
        }

        // Calculate the sum of elements in nums2 and count zeroes
        for (int num : nums2) {
            sum2 += num; // Add each number to sum2
            if (num == 0) {
                zeroes2++; // Increment zeroes2 if the number is zero
            }
        }

        // Calculate minimum sums considering the zero counts
        long minsum1 = sum1 + zeroes1; // Minimum sum for nums1
        long minsum2 = sum2 + zeroes2; // Minimum sum for nums2

        // Check conditions for returning -1 based on zero counts and minimum sums
        if (zeroes1 == 0 && minsum1 < minsum2) {
            return -1; // Return -1 if nums1 has no zeroes and its min sum is less
        }
        if (zeroes2 == 0 && minsum1 > minsum2) {
            return -1; // Return -1 if nums2 has no zeroes and its min sum is greater
        }

        // Return the maximum of the two minimum sums
        return Math.max(minsum1, minsum2);
    }
}
