class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Step 1: Sort the happiness array in ascending order.
        // This allows us to easily access the largest happiness values from the end.
        Arrays.sort(happiness);

        // 'count' keeps track of how many children have been picked so far.
        // It is used to simulate the cumulative reduction in happiness for each subsequent pick.
        int count = 0;

        // 'result' will accumulate the total happiness sum (use long to avoid overflow).
        long result = 0;

        // Step 2: Iterate over the k largest happiness values (from the end of the sorted array).
        // For each pick, the happiness of all remaining children is reduced by 1.
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            // Calculate the effective happiness for the current child after reductions.
            int currentHappiness = happiness[i] + count;

            // Only add to the result if the effective happiness is positive.
            // If it is zero or negative, we skip adding it (as per problem statement).
            if (currentHappiness > 0) {
                result += (long) currentHappiness;
            }

            // After picking a child, decrease 'count' by 1 to simulate the reduction
            // in happiness for the next round of picks.
            count--;
        }

        // Step 3: Return the total maximum happiness sum.
        return result;
    }
}
