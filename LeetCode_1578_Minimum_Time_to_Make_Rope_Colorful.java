class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        // Initialize sum to accumulate the total minimum removal cost.
        int sum = 0;
        
        // Start from the second balloon (index 1) and iterate through the string.
        for (int i = 1; i < colors.length(); i++) {
            
            // Check if the current balloon has the same color as the previous one.
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                
                // If so, we need to remove one of them to avoid consecutive duplicates.
                // Add the smaller neededTime between the current and previous balloon to sum.
                // This represents removing the cheaper balloon.
                sum += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Update neededTime[i] to the larger of the two times.
                // This ensures that for any further consecutive duplicates,
                // we always compare against the most expensive balloon kept so far.
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        
        // After processing all balloons, return the total minimum cost.
        return sum;
    }
}
