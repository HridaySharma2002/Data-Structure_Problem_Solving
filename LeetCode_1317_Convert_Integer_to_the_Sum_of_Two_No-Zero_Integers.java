class Solution {
    public int[] getNoZeroIntegers(int n) {
        // Try all possible values for 'a' from 1 to n-1
        for(int a = 1; a < n; a++) {
            int b = n - a; // Calculate b so that a + b = n
            // Check if both a and b are No-Zero integers
            if(isnotzero(a) && isnotzero(b)) {
                // Return the pair as soon as a valid one is found
                return new int[]{a, b};
            }
        }
        // According to the problem, there is always at least one solution
        return null;
    }

    // Helper method to check if a number contains any zero digit
    private boolean isnotzero(int num) {
        while(num > 0) {
            if(num % 10 == 0) { // If any digit is zero, return false
                return false;
            }
            num /= 10; // Move to the next digit
        }
        return true; // No zero digit found, return true
    }
}
