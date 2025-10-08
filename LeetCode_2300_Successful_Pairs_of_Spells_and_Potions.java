class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array to enable binary search
        Arrays.sort(potions);

        int n = spells.length;      // Number of spells
        int m = potions.length;     // Number of potions
        int result[] = new int[n];  // Array to store the answer for each spell

        // Iterate through each spell
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int index = -1; // To store the first valid potion index

            // Binary search to find the smallest index such that
            // spells[i] * potions[index] >= success
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // If the product meets or exceeds success, search left half
                if ((long)spells[i] * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    // Otherwise, search right half
                    left = mid + 1;
                }
            }

            // If index is -1, no valid potion found; else, count from index to end
            result[i] = (index == -1) ? 0 : (m - index);
        }

        // Return the result array containing the number of successful pairs for each spell
        return result;
    }
}
