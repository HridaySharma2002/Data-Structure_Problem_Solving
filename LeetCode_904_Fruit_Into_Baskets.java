class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0; // Initialize the left pointer for the sliding window
        int right = 0; // Initialize the right pointer for the sliding window
        int max_pick_up = 0; // Variable to store the maximum number of fruits picked
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to count the number of each fruit type

        // Iterate through the array using the right pointer
        while (right < fruits.length) {
            // Add the current fruit to the map and increment its count
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 unique fruit types, shrink the window from the left
            while (map.size() > 2) {
                // Decrement the count of the fruit at the left pointer
                map.put(fruits[left], map.get(fruits[left]) - 1);
                // If the count of that fruit becomes zero, remove it from the map
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++; // Move the left pointer to the right
            }

            // Update the maximum number of fruits picked if the current window is valid
            max_pick_up = Math.max(max_pick_up, right - left + 1);
            right++; // Move the right pointer to the right
        }
        
        return max_pick_up; // Return the maximum number of fruits picked
    }
}
