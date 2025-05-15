class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0; // Initialize a counter for equivalent domino pairs
        HashMap<Integer, Integer> countMap = new HashMap<>(); // HashMap to store counts of unique domino configurations
        
        // Iterate through each domino in the input array
        for (int[] domino : dominoes) {
            // Create a unique key for each domino by sorting the values
            int key = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            
            // Add the current count of this key to the total count of equivalent pairs
            count += countMap.getOrDefault(key, 0);
            
            // Increment the count for this key in the HashMap
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        
        return count; // Return the total count of equivalent domino pairs
    }
}
