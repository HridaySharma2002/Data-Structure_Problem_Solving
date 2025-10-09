class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length; // Number of skills
        int m = mana.length;  // Number of mana values
        long done[] = new long[n + 1]; // done[i] stores the minimum time to finish the first i skills

        // Iterate over each mana value
        for (int i = 0; i < m; i++) {
            // Forward pass: update done[j+1] using the current mana[i]
            for (int j = 0; j < n; j++) {
                // The time to finish first (j+1) skills is the maximum of:
                // - the current value of done[j+1]
                // - the time to finish first j skills
                // Then add the cost of doing skill[j] with mana[i]
                done[j + 1] = Math.max(done[j + 1], done[j]) + (long) mana[i] * skill[j];
            }
            // Backward pass: prepare done[] for the next mana value
            for (int j = n - 1; j > 0; j--) {
                // Roll back the addition to keep done[] correct for the next iteration
                done[j] = done[j + 1] - (long) mana[i] * skill[j];
            }
        }
        // The answer is the minimum time to finish all n skills
        return done[n];
    }
}
