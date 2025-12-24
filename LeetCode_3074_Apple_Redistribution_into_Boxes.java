class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Calculate the total number of apples from all piles
        int total_apples = 0;
        for (int apples : apple) {
            total_apples += apples;
        }

        // Frequency array to count how many boxes there are for each capacity (capacity range assumed up to 50)
        int freq[] = new int[51];

        // Initialize low and high to track the minimum and maximum box capacities available
        int low = 51;
        int high = 0;

        // Populate frequency array and find the min and max capacity values
        for (int cap : capacity) {
            freq[cap]++;
            high = Math.max(high, cap);
            low = Math.min(low, cap);
        }

        // Result variable to count the number of boxes used
        int result = 0;

        // Start from the largest capacity boxes and use them first to store apples
        for (int i = high; i >= low && total_apples > 0; i--) {
            // Use all boxes of capacity i while there are apples left to store
            while (freq[i]-- > 0 && total_apples > 0) {
                total_apples -= i;  // Store apples in the current box
                result++;           // Increment the count of boxes used
            }
        }

        // Return the total number of boxes used to store all apples
        return result;
    }
}
