class Solution {
    // Map to store all possible top blocks for each pair of bottom blocks
    // For example, if "ABC" is allowed, then map.get("AB") will contain 'C'
    Map<String, List<Character>> map = new HashMap<>();
    // Memoization map to cache results for each bottom row configuration
    Map<String, Boolean> memo = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build the map from allowed patterns
        for (String s : allowed) {
            String key = s.substring(0, 2); // The base (first two characters)
            // Add the top block (third character) to the list for this base
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        // Start the recursive process from the given bottom row
        return solve(bottom);
    }

    // Recursive function to check if we can build a pyramid from the current bottom row
    private boolean solve(String bottom) {
        // Base case: if only one block is left, we've built the pyramid successfully
        if (bottom.length() == 1) {
            return true;
        }
        // If we've already computed the result for this row, return it (memoization)
        if (memo.containsKey(bottom)) {
            return memo.get(bottom);
        }
        // Try to generate all possible next rows and check if any can lead to a solution
        boolean result = generatenextrow(bottom, 0, new StringBuilder());
        // Cache the result for this row
        memo.put(bottom, result);
        return result;
    }

    // Helper function to generate all possible next rows using DFS/backtracking
    private boolean generatenextrow(String bottom, int index, StringBuilder currentnext) {
        // If we've built the next row completely, try to solve for it recursively
        if (index == bottom.length() - 1) {
            return solve(currentnext.toString());
        }
        // Get the current pair of blocks as the key
        String key = bottom.substring(index, index + 2);
        // If there are no allowed patterns for this pair, return false (dead end)
        if (!map.containsKey(key)) {
            return false;
        }
        // Try each possible top block for this pair
        for (char val : map.get(key)) {
            currentnext.append(val); // Add the top block to the next row
            // Recursively try to build the rest of the next row
            if (generatenextrow(bottom, index + 1, currentnext)) {
                return true; // If any path works, return true
            }
            currentnext.deleteCharAt(currentnext.length() - 1); // Backtrack
        }
        // If none of the options work, return false
        return false;
    }
}
