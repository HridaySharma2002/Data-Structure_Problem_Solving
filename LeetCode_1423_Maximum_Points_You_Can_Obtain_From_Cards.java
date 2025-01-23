class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Initialize scores for the left and right selections, and the maximum score
        int left_score = 0;
        int right_score = 0;
        int max_score = 0;

        // Calculate the initial score by taking the first k cards from the left
        for (int i = 0; i < k; i++) {
            left_score += cardPoints[i]; // Add the points of the left cards
            max_score = left_score; // Set max_score to the current left_score
        }

        // Start taking cards from the right side
        int right_index = cardPoints.length - 1; // Index for the rightmost card
        for (int i = k - 1; i >= 0; i--) {
            left_score -= cardPoints[i]; // Remove the points of the left card being replaced
            right_score += cardPoints[right_index]; // Add the points of the right card
            right_index--; // Move to the next right card
            // Update max_score if the new combination of left and right scores is higher
            max_score = Math.max(max_score, left_score + right_score);
        }

        // Return the maximum score obtained
        return max_score;
    }
}
