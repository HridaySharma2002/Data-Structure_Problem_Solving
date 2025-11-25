class Solution {
    public int smallestRepunitDivByK(int k) {
        // If k is divisible by 2 or 5, there is no repunit (number made only of 1's) divisible by k.
        // This is because such numbers always end with 1, so can't be divisible by 2 or 5.
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }

        // rem stores the current remainder when the repunit is divided by k.
        // Start with the first repunit "1", so rem = 1 % k.
        int rem = 1 % k;

        // len keeps track of the length of the current repunit (number of 1's).
        int len = 1;

        // Loop until the remainder becomes 0, which means the current repunit is divisible by k.
        while(rem > 0){
            // To form the next repunit, append another '1' to the right.
            // Instead of building the actual number (which would be huge), update the remainder:
            // If current repunit is R, next is R*10 + 1. So, new remainder is (rem*10 + 1) % k.
            rem = (rem * 10 + 1) % k;
            len++;

            // If we've tried more than k different lengths, we're in a cycle and will never reach remainder 0.
            // This is due to the pigeonhole principle: there are only k possible remainders.
            if(len > k){
                return -1;
            }
        }

        // If we exit the loop, it means we've found a repunit of length 'len' divisible by k.
        return len;
    }
}
