class Solution {
    public boolean isHappy(int n) {
        int slow = n;  // slow pointer starts at n
        int fast = n;  // fast pointer starts at n

        // Move slow pointer one step ahead (sum of squares once)
        slow = square(slow);
        // Move fast pointer two steps ahead (sum of squares twice)
        fast = square(square(fast));

        // Loop until slow and fast pointers meet
        // If they meet at 1, number is happy
        // If they meet at any other number, a cycle exists and number is not happy
        while (slow != fast) {
            slow = square(slow);           // move slow pointer one step
            fast = square(square(fast));   // move fast pointer two steps
        }

        // If the meeting point is 1, return true (happy number)
        return slow == 1;
    }

    // Helper method to calculate the sum of the squares of digits of num
    public int square(int num) {
        int result = 0;  // accumulator for sum of squares

        // Process each digit of num
        while (num != 0) {
            int digit = num % 10;       // extract last digit
            result += digit * digit;    // add square of digit to result
            num /= 10;                  // remove last digit
        }

        return result;  // return the sum of squares of digits
    }
}
