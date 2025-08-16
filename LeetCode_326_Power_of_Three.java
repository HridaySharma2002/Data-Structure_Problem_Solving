class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;  // Negative numbers and zero cannot be powers of three
        
        // Keep dividing n by 3 while it is divisible by 3
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // After dividing out all factors of 3, if n is 1, it was a power of three
        return n == 1;
    }
}
