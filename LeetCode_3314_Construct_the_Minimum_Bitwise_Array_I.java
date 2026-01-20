class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        // Initialize the result array with the same size as the input list
        int result[] = new int[nums.size()];
        
        // Iterate over each element in the input list
        for (int i = 0; i < nums.size(); i++) {
            // Check if the current number is odd by testing the least significant bit
            if ((nums.get(i) & 1) == 1) {
                /*
                 * For odd numbers:
                 * 1. Compute (nums.get(i) + 1) & ~nums.get(i)
                 *    - This isolates the rightmost zero bit in the binary representation of the number.
                 * 2. Right shift the result by 1 to move one bit to the right.
                 * 3. Apply bitwise NOT (~) to this shifted value.
                 * 4. Perform bitwise AND with the original number to clear the rightmost set bit
                 *    that is immediately followed by a zero bit.
                 * This effectively finds the next smaller number with fewer or equal set bits.
                 */
                result[i] = nums.get(i) & ~(((nums.get(i) + 1) & ~nums.get(i)) >> 1);
            } else {
                // For even numbers, assign -1 as per the problem's requirement
                result[i] = -1;
            }
        }
        
        // Return the resulting array after processing all elements
        return result;
    }
}
