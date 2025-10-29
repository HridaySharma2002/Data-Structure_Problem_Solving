class Solution {
    public int smallestNumber(int n) {
        // Loop through increasing values of i to find the smallest power of two greater than n
        for(int i = 0; i <= n; i++) {
            // Calculate the Mersenne number: 2^i (using bit shift) 
            int mersenne_number = 1 << i;
            // If this Mersenne number exceeds n, return the previous Mersenne number (2^i - 1)
            if(mersenne_number > n) {
                return mersenne_number - 1;
            }
        }
        // This return is a fallback; for all practical n >= 0, the loop will return before this point
        return 0;
    }
}
