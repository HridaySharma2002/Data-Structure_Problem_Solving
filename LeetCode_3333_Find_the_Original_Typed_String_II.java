class Solution {
    // Constant for modulo operation to prevent overflow
    private static final int MOD = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        // If the input string is empty, return 0 as there are no possible original strings
        if (word.isEmpty()) {
            return 0;
        }

        // List to store the counts of consecutive identical characters
        List<Integer> groups = new ArrayList<>();
        int count = 1; // Initialize count for consecutive characters

        // Loop through the string to count consecutive characters
        for (int i = 1; i < word.length(); i++) {
            // If the current character is the same as the previous one, increment count
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                // If the character changes, add the count to groups and reset count
                groups.add(count);
                count = 1; // Reset count for the new character
            }
        }
        // Add the count of the last group of characters
        groups.add(count);

        // Calculate the total number of combinations based on the groups
        long total = 1;
        for (int num : groups) {
            total = (total * num) % MOD; // Multiply counts and take modulo
        }

        // If k is less than or equal to the number of groups, return total combinations
        if (k <= groups.size()) {
            return (int) total;
        }

        // Dynamic programming array to count ways to form strings of different lengths
        int[] dp = new int[k];
        dp[0] = 1; // Base case: one way to form an empty string

        // Process each group of consecutive characters
        for (int num : groups) {
            int[] newDp = new int[k]; // New DP array for the current group
            long sum = 0; // Variable to accumulate counts

            // Update the DP array for lengths from 0 to k-1
            for (int s = 0; s < k; s++) {
                // If s > 0, add the number of ways to form strings of length s-1
                if (s > 0) {
                    sum = (sum + dp[s - 1]) % MOD;
                }
                // If s > num, subtract the number of ways to form strings of length s-num-1
                if (s > num) {
                    sum = (sum - dp[s - num - 1] + MOD) % MOD; // Ensure non-negative
                }
                newDp[s] = (int) sum; // Store the result in the new DP array
            }
            dp = newDp; // Update dp to the new DP array for the next group
        }

        // Count invalid combinations that have lengths less than k
        long invalid = 0;
        for (int s = groups.size(); s < k; s++) {
            invalid = (invalid + dp[s]) % MOD; // Accumulate invalid counts
        }

        // Return the total valid combinations by subtracting invalid from total
        return (int) ((total - invalid + MOD) % MOD); // Ensure non-negative result
    }
}
