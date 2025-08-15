class Solution {
    // Function to count the number of '1' bits (Hamming weight) in the integer n
    public int hammingWeight(int n) {
        int bitcount = 0;  // Initialize count of set bits to zero
        
        // Loop through all 32 bits of the integer (since int is 32-bit in Java)
        for (int i = 0; i < 32; i++) {
            // Right shift n by i bits, then bitwise AND with 1 to isolate the bit at position i
            // If the isolated bit is 1, increment bitcount
            if (((n >> i) & 1) == 1) {
                bitcount++;
            }
        }
        
        // Return the total count of bits set to 1
        return bitcount;
    }
}
