class Solution {
    public int candy(int[] ratings) {
        int sum = 1; // Initialize sum to 1 to account for the first child receiving at least one candy
        int i = 1; // Start from the second child

        // Iterate through the ratings array
        while (i < ratings.length) {
            // If the current child's rating is equal to the previous child's rating
            if (ratings[i] == ratings[i - 1]) {
                sum++; // Increment sum for the current child
                i++; // Move to the next child
                continue; // Continue to the next iteration
            }

            int peak = 1; // Initialize peak for the increasing sequence of ratings
            // Count the number of children with increasing ratings
            while (i < ratings.length && ratings[i] > ratings[i - 1]) {
                peak++; // Increment peak for each child with a higher rating
                sum += peak; // Add the number of candies for the current peak
                i++; // Move to the next child
            }

            int down = 1; // Initialize down for the decreasing sequence of ratings
            // Count the number of children with decreasing ratings
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                sum += down; // Add the number of candies for the current down
                down++; // Increment down for the next child
                i++; // Move to the next child
            }

            // If the down sequence is longer than the peak sequence
            if (down > peak) {
                sum += down - peak; // Adjust the sum to account for the excess candies needed
            }
        }
        return sum; // Return the total number of candies distributed
    }
}
