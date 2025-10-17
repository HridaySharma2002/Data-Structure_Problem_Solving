class Solution {
    // Memoization map to store results for each unique DP state
    // Key: "i,currMask,canChange", Value: max partitions from this state
    private Map<String,Integer> memo = new HashMap<>();
    private String s; // The input string
    private int k;    // Max distinct characters allowed in a partition

    // Main function to be called
    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.memo.clear(); // Clear memoization map before starting
        // Start DFS from index 0, with empty mask, and change available
        return dfs(0, 0, true);
    }

    /**
     * Recursive DP function.
     * @param i         Current index in the string
     * @param currMask  Bitmask representing distinct characters in current partition
     * @param canChange Whether the one allowed character change is still available
     * @return          Maximum number of partitions from this state
     */
    private int dfs(int i, int currMask, boolean canChange) {
        // Base case: if we've processed all characters
        if (i >= s.length()) {
            // If current partition is non-empty, count it as 1
            return currMask > 0 ? 1 : 0;
        }

        // Create a unique key for the current state for memoization
        String key = i + "," + currMask + "," + canChange;
        if (memo.containsKey(key)) {
            // Return cached result if already computed
            return memo.get(key);
        }

        // Option 1: Do NOT change the current character
        int charbit = 1 << (s.charAt(i) - 'a'); // Bit for current character
        int newMask = currMask | charbit;       // Add current char to mask
        int distinctcount = Integer.bitCount(newMask); // Count distinct chars in mask
        int result = 0;

        if (distinctcount <= k) {
            // Continue current partition if within k distinct characters
            result = Math.max(result, dfs(i + 1, newMask, canChange));
        } else {
            // Otherwise, start a new partition from this character
            result = Math.max(result, 1 + dfs(i + 1, charbit, canChange));
        }

        // Option 2: Change the current character (if allowed)
        if (canChange) {
            // Try changing to every possible lowercase letter
            for (int c = 0; c < 26; c++) {
                int newcharbit = 1 << c; // Bit for the changed character
                int newMaskChanged = currMask | newcharbit;
                int distinctcountchanged = Integer.bitCount(newMaskChanged);

                if (distinctcountchanged <= k) {
                    // Continue current partition with changed character
                    result = Math.max(result, dfs(i + 1, newMaskChanged, false));
                } else {
                    // Start new partition with changed character
                    result = Math.max(result, 1 + dfs(i + 1, newcharbit, false));
                }
            }
        }

        // Store result in memoization map before returning
        memo.put(key, result);
        return result;
    }
}
