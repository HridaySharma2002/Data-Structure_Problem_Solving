class Solution {
    public int minDeletionSize(String[] strs) {
        int deletecount = 0; // Initialize count of columns to delete
        
        // Iterate over each column index
        for (int i = 0; i < strs[0].length(); i++) {
            // Check each row from the second one onwards
            for (int j = 1; j < strs.length; j++) {
                // If current character is smaller than the character in the previous row,
                // this column is not sorted lexicographically
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deletecount++; // Increment delete count for this column
                    break; // No need to check further rows for this column
                }
            }
        }
        
        return deletecount; // Return total number of columns to delete
    }
}
