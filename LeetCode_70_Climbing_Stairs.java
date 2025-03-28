class Solution {
    public int climbStairs(int n) {
        // Handle base cases
        if (n == 0) {
            return 0; // If there are no steps, there are no ways to climb
        }
        if (n == 1) {
            return 1; // If there is one step, there is only one way to climb it
        }

        // Initialize variables to store the number of ways to reach the previous two steps
        int prev2 = 0; // Represents the number of ways to reach step (n-2)
        int prev = 1;  // Represents the number of ways to reach step (n-1)
        int curr = 0;  // Variable to store the current number of ways to reach step n

        // Iterate from step 1 to n to calculate the number of ways to reach each step
        for (int i = 1; i <= n; i++) {
            curr = prev + prev2; // The current step can be reached from the previous step or the one before that
            prev2 = prev; // Update prev2 to the previous step's value
            prev = curr;  // Update prev to the current step's value
        }

        // Return the total number of ways to reach the nth step
        return curr;
    }
}
