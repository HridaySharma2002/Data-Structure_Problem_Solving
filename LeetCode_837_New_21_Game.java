class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // If k == 0, no cards are drawn, so probability of <= n is 1
        // If n is large enough that even the max possible score after stopping is <= n, probability is 1
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0;
        }

        // dp array to store probabilities of reaching each score modulo maxPts (sliding window)
        double dp[] = new double[maxPts];
        dp[0] = 1.0;  // Starting at score 0 with probability 1

        double windowSum = 1.0;  // Sum of probabilities in the current sliding window
        double result = 0.0;     // Accumulates probability of stopping with score in [k, n]

        // Iterate through all possible scores from 1 to n
        for (int i = 1; i <= n; i++) {
            // Probability of reaching score i is average of probabilities in the sliding window
            double prob = windowSum / maxPts;

            if (i < k) {
                // Still drawing cards, add this probability to the window sum for future scores
                windowSum += prob;
            } else {
                // Reached or passed k, stop drawing, add probability to result
                result += prob;
            }

            // Remove the probability that falls out of the sliding window to keep window size = maxPts
            if (i >= maxPts) {
                windowSum -= dp[i % maxPts];
            }

            // Store current probability in dp array using modulo for circular indexing
            dp[i % maxPts] = prob;
        }

        // Return the total probability of stopping with score <= n and >= k
        return result;
    }
}
