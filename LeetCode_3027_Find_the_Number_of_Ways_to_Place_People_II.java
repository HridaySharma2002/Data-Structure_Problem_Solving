class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort points by x descending, then by y ascending
        Arrays.parallelSort(points, (a, b) -> {
            return a[0] == b[0] ? (a[1] - b[1]) : (b[0] - a[0]);
        });

        final int totalPoints = points.length; // Total number of points
        int pairCount = 0;                     // Count of valid (Alice, Bob) pairs

        // Iterate over each point as Alice (upper-left corner)
        for (int aliceIndex = 0; aliceIndex < totalPoints - 1; aliceIndex++) {
            int aliceX = points[aliceIndex][0];
            int aliceY = points[aliceIndex][1];
            int lowestBobY = Integer.MAX_VALUE; // Tracks lowest y for Bob candidates

            // Iterate over subsequent points as Bob (lower-right corner)
            for (int bobIndex = aliceIndex + 1; bobIndex < totalPoints; bobIndex++) {
                int bobX = points[bobIndex][0];
                int bobY = points[bobIndex][1];

                // Check if Bob is below or at Alice's y and has a lower y than previous Bob candidates
                if (bobY < lowestBobY && bobY >= aliceY) {
                    pairCount++;          // Valid pair found
                    lowestBobY = bobY;    // Update lowest Bob y

                    // If Alice and Bob share the same y, no further Bob can be valid for this Alice
                    if (aliceY == bobY) {
                        break;
                    }
                }
            }
        }
        return pairCount;
    }
}
