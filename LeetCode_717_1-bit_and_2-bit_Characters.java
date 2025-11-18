class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        // Iterate through the bits array until the second last element
        while (i < bits.length - 1) {
            // If bits[i] is 1, it means this character is two bits long (10 or 11),
            // so we skip the next bit by adding 2 (bits[i] + 1 = 1 + 1 = 2)
            // If bits[i] is 0, it means this character is one bit long,
            // so we move forward by 1 (bits[i] + 1 = 0 + 1 = 1)
            i += bits[i] + 1;
        }
        // After the loop, if i is exactly at the last index,
        // it means the last character is a one-bit character (0)
        return i == bits.length - 1;
    }
}
