class Solution {
    // Method to calculate the number of unplaced fruits
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int alloted = 0; // Counter for fruits that have been placed in baskets

        // Iterate over each fruit
        for (int i = 0; i < fruits.length; i++) {
            // Try to place the current fruit in any available basket
            for (int j = 0; j < fruits.length; j++) {
                // If the current basket can hold the fruit
                if (fruits[i] <= baskets[j]) {
                    alloted++;           // Increment the count of placed fruits
                    baskets[j] = -1;     // Mark this basket as used by setting its capacity to -1
                    break;               // Move to the next fruit after placing
                }
            }
        }
        // Return the number of fruits that could not be placed in any basket
        return fruits.length - alloted;
    }
}
