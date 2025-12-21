class Solution {
    public int minDeletionSize(String[] strs) {
        // Boolean array to track which adjacent pairs of strings are confirmed sorted
        // sorted[i] = true means strs[i] <= strs[i+1] is confirmed and no longer needs checking
        boolean[] sorted = new boolean[strs.length - 1];
        
        // Count of columns that need to be deleted
        int deletions = 0;
        
        // Iterate over each column index i (from 0 to length of strings - 1)
        for (int i = 0; i < strs[0].length(); i++) {
            // Flag to check if current column must be deleted
            boolean needDelete = false;
            
            // Check all adjacent pairs of strings to see if this column breaks lex order
            for (int j = 0; j < strs.length - 1; j++) {
                // Only consider pairs not already confirmed sorted
                if (!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    // Current column breaks order, so mark for deletion
                    needDelete = true;
                    break;  // No need to check further pairs for this column
                }
            }
            
            // If column must be deleted, increment deletions and skip updating sorted array
            if (needDelete) {
                deletions++;
                continue;
            }
            
            // If column is kept, update sorted array for pairs that become confirmed sorted
            for (int j = 0; j < strs.length - 1; j++) {
                // For pairs not yet confirmed sorted, check if this column confirms order
                if (!sorted[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                    sorted[j] = true;  // Mark this pair as sorted
                }
            }
        }
        
        // Return the minimum number of columns deleted to make array sorted
        return deletions;
    }
}
