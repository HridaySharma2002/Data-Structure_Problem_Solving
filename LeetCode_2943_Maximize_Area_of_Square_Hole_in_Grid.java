class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Sort the horizontal bars array to find consecutive removable bars easily
        Arrays.sort(hBars);
        // Sort the vertical bars array similarly
        Arrays.sort(vBars);

        // Find the longest consecutive sequence of removable horizontal bars
        int maxHorizontal = maxspan(hBars);
        // Find the longest consecutive sequence of removable vertical bars
        int maxVertical = maxspan(vBars);

        // The side length of the largest square hole is the minimum of these two sequences plus 1
        // +1 because the hole length is one more than the number of bars removed consecutively
        int side = Math.min(maxHorizontal, maxVertical) + 1;

        // Return the area of the square hole (side length squared)
        return side * side;
    }

    // Helper method to find the longest consecutive sequence in a sorted array
    private int maxspan(int[] bars) {
        int currentstreak = 1;  // Current count of consecutive bars
        int maxstreak = 1;      // Maximum consecutive bars found so far

        // Iterate through the bars starting from the second element
        for (int i = 1; i < bars.length; i++) {
            // Check if current bar is exactly 1 greater than previous (consecutive)
            if (bars[i] == bars[i - 1] + 1) {
                currentstreak++;  // Increase current streak count
                continue;
            } else {
                // If not consecutive, update max streak if current is larger
                maxstreak = Math.max(maxstreak, currentstreak);
                // Reset current streak count
                currentstreak = 1;
            }
        }
        // Return the maximum between max streak and the last current streak
        return Math.max(maxstreak, currentstreak);
    }
}
