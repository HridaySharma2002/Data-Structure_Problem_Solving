class Solution {
    public int numberOfBeams(String[] bank) {
        int result = 0; // Stores the total number of beams
        int prev = 0;   // Stores the number of devices in the previous non-empty row
        int n = bank[0].length(); // Number of columns in the bank

        // Iterate through each row in the bank
        for (String row : bank) {
            int dev = 0; // Count of devices in the current row

            // Count the number of devices ('1's) in the current row
            for (int j = 0; j < n; j++) {
                dev += (row.charAt(j) == '1' ? 1 : 0);
            }

            // If the current row has at least one device
            if (dev > 0) {
                // Add beams formed between this row and the previous non-empty row
                result += dev * prev;
                // Update prev to the current row's device count
                prev = dev;
            }
        }
        return result; // Return the total number of beams
    }
}
