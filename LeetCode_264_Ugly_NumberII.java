class Solution {
    public int nthUglyNumber(int n) {
        // Array to store the first n ugly numbers
        int[] ugly = new int[n];
        ugly[0] = 1; // The first ugly number is 1

        // Initialize pointers for 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;

        // Next multiples of 2, 3, and 5
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            // Find the next ugly number
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            // Increment the pointer for the respective factor
            if (nextUgly == next2) {
                i2++;
                next2 = ugly[i2] * 2; // Update next multiple of 2
            }
            if (nextUgly == next3) {
                i3++;
                next3 = ugly[i3] * 3; // Update next multiple of 3
            }
            if (nextUgly == next5) {
                i5++;
                next5 = ugly[i5] * 5; // Update next multiple of 5
            }
        }

        return ugly[n - 1]; // Return the nth ugly number
    }
}
