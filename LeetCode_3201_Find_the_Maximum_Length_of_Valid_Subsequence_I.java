class Solution {
    public int maximumLength(int[] nums) {
        // count1 counts the number of even numbers in nums
        int count1 = 0;
        // count2 counts the number of odd numbers in nums
        int count2 = 0;

        // First pass: count how many even and odd numbers are in the array
        for (int num : nums) {
            if (num % 2 == 0) {
                count1++;  // increment even count
            } else {
                count2++;  // increment odd count
            }
        }

        // even and odd track the length of the longest valid subsequence
        // ending with an even or odd number respectively, where the parity
        // of sums of adjacent pairs is consistent
        int even = 0;
        int odd = 0;

        // Second pass: build the longest valid subsequence by alternating parity
        for (int num : nums) {
            if (num % 2 == 0) {
                // If current number is even, try to extend subsequence ending with odd
                even = Math.max(even, odd + 1);
            } else {
                // If current number is odd, try to extend subsequence ending with even
                odd = Math.max(odd, even + 1);
            }
        }

        // The answer is the maximum among:
        // - all even numbers subsequence length (count1)
        // - all odd numbers subsequence length (count2)
        // - longest alternating parity subsequence length (even or odd)
        return Math.max(Math.max(count1, count2), Math.max(even, odd));
    }
}
