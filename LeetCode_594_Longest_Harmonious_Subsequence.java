class Solution {
    public int findLHS(int[] nums) {
        // Create a HashMap to store the frequency of each number in the array
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Iterate through the input array to populate the countMap
        for (int num : nums) {
            // For each number, update its count in the map
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Initialize a variable to keep track of the maximum length of harmonious subsequence
        int maxlength = 0;

        // Iterate through the keys in the countMap
        for (int key : countMap.keySet()) {
            // Check if there exists a consecutive number (key + 1)
            if (countMap.containsKey(key + 1)) {
                // Calculate the length of the harmonious subsequence formed by key and key + 1
                maxlength = Math.max(maxlength, countMap.get(key) + countMap.get(key + 1));
            }
        }

        // Return the maximum length found
        return maxlength;
    }
}
