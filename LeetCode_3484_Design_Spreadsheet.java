class Spreadsheet {
    private int[][] cells;  // 2D array to store cell values; rows x 26 columns (A-Z)

    // Constructor to initialize the spreadsheet with given number of rows
    public Spreadsheet(int rows) {
        cells = new int[rows][26];  // Initialize all cells to 0 by default
    }
    
    // Set the value of a specific cell, e.g. "A1", "B3"
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';  // Convert column letter to index (A=0, B=1, ...)
        int row = Integer.parseInt(cell.substring(1)) - 1;  // Convert row number to zero-based index
        cells[row][col] = value;  // Store the value in the cells array
    }
    
    // Reset the value of a specific cell to 0
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';  // Column index
        int row = Integer.parseInt(cell.substring(1)) - 1;  // Row index
        cells[row][col] = 0;  // Reset cell value to zero
    }
    
    // Evaluate a formula string of the form "=X+Y" where X and Y can be either:
    // - a cell reference like "A1", "B2"
    // - or a direct integer value like "5", "10"
    public int getValue(String formula) {
        int idx = formula.indexOf('+');  // Find the position of the '+' operator
        
        // Extract the left operand (skip the initial '=' at index 0)
        String left = formula.substring(1, idx);
        // Extract the right operand (everything after '+')
        String right = formula.substring(idx + 1);

        // Evaluate left operand:
        // If it starts with a letter, treat as cell reference and fetch value from cells array
        // Otherwise, parse it as an integer
        int valLeft = Character.isLetter(left.charAt(0)) 
            ? cells[Integer.parseInt(left.substring(1)) - 1][left.charAt(0) - 'A'] 
            : Integer.parseInt(left);

        // Evaluate right operand with the same logic as left
        int valRight = Character.isLetter(right.charAt(0)) 
            ? cells[Integer.parseInt(right.substring(1)) - 1][right.charAt(0) - 'A'] 
            : Integer.parseInt(right);

        // Return the sum of the two evaluated values
        return valLeft + valRight;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
