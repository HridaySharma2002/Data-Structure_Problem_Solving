class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0; // Initialize the operation counter to zero
        // Continue looping as long as both numbers are not zero
        while (num1 != 0 && num2 != 0) {
            // If num1 is greater than or equal to num2, subtract num2 from num1
            if (num1 >= num2) {
                num1 -= num2;
            } else { // Otherwise, subtract num1 from num2
                num2 -= num1;
            }
            count++; // Increment the operation counter after each subtraction
        }
        // Return the total number of operations performed
        return count;
    }
}
