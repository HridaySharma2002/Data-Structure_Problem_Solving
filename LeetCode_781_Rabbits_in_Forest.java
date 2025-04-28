class Solution {
    public int numRabbits(int[] answers) {
        // Initialize the total number of rabbits to 0
        int totalRabbits = 0;
        
        // Create an array to count occurrences of each possible answer (0 to 999)
        int count[] = new int[1000];
        
        // Count how many times each answer appears in the answers array
        for (int answer : answers) {
            count[answer]++;
        }

        // Iterate through the count array to calculate the minimum number of rabbits
        for (int i = 0; i < count.length; i++) {
            // Only process if there are rabbits that provided this answer
            if (count[i] > 0) {
                // Calculate the number of complete groups of rabbits needed
                // Each group consists of (i + 1) rabbits
                totalRabbits += (count[i] + i) / (i + 1) * (i + 1);
            }
        }

        // Return the total number of rabbits calculated
        return totalRabbits;
    }
}
