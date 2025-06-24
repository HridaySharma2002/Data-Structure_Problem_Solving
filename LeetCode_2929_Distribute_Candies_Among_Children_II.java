class Solution {
    public long distributeCandies(int n, int limit) {
        // Initialize the result variable to accumulate the total number of ways
        long result = 0;

        // Loop through possible distributions for the first child
        // i represents the number of candies given to the first child
        for (int i = 0; i <= Math.min(limit, n); i++) {
            // Check if the remaining candies can be distributed to the other two children
            // The condition ensures that the remaining candies do not exceed twice the limit
            if (n - i <= 2 * limit) {
                // Calculate the number of valid distributions for the remaining candies
                // Math.min(n - i, limit) gives the maximum candies the second child can receive
                // Math.max(0, n - i - limit) calculates how many candies exceed the limit for the second child
                // The +1 accounts for the inclusive range of valid distributions
                result += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
            }
        }
        
        // Return the total number of valid distributions
        return result;
    }
}
