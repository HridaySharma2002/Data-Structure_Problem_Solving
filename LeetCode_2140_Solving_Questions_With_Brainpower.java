class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length; // Get the number of questions
        long dp[] = new long[n + 1]; // Create a DP array to store maximum points from each question onwards

        // Iterate from the last question to the first
        for (int i = n - 1; i >= 0; i--) {
            // Option 1: Skip the current question
            dp[i] = dp[i + 1]; // If we skip, the maximum points are the same as from the next question

            // Option 2: Solve the current question
            int next_question = i + questions[i][1] + 1; // Calculate the index of the next question we can solve
            long points_earned = questions[i][0]; // Points earned by solving the current question

            // If the next question index is within bounds, add the points from future questions
            if (next_question <= n) {
                points_earned += dp[next_question]; // Add points from the next possible questions
            }

            // Take the maximum of solving or skipping the current question
            dp[i] = Math.max(dp[i], points_earned);
        }

        // Return the maximum points we can earn starting from the first question
        return dp[0];
    }
}
