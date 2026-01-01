class Solution {
    public int[] plusOne(int[] digits) {
        // Iterate from the last digit to the first digit
        for(int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is not 9, simply increment it by 1
            if(digits[i] != 9) {
                digits[i] += 1;
                // Return the array immediately since no further carry is needed
                return digits;
            }
            // If the digit is 9, it becomes 0 due to carry over
            digits[i] = 0;
        }
        // If all digits were 9, we reach here after the loop
        // Create a new array with one extra digit to hold the carry
        digits = new int[digits.length + 1];
        // Set the most significant digit to 1 (e.g., 999 + 1 = 1000)
        digits[0] = 1;
        // Return the new array with the carry handled
        return digits;
    }
}
