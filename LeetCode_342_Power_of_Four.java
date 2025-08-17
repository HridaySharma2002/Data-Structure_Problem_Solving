class Solution {
    // Function to check if a number n is a power of four
    public boolean isPowerOfFour(int n) {
        // If n is less than or equal to zero, it cannot be a power of four
        if (n <= 0) {
            return false;
        }
        
        // Keep dividing n by 4 while it is divisible by 4
        while (n % 4 == 0) {
            n /= 4;  // Divide n by 4
        }
        
        // After dividing out all factors of 4, if n is 1, then n is a power of four
        return n == 1;
    }
}
