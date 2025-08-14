class Solution {
    public String convert(String s, int numRows) {
        // If only one row, no zigzagging needed; return original string
        if(numRows == 1){
            return s;
        }
        
        // StringBuilder to efficiently build the resulting string
        StringBuilder str = new StringBuilder();
        
        // Loop through each row
        for(int i = 0; i < numRows; i++){
            // j starts at the current row index i
            // Step size is the full cycle length: 2 * (numRows - 1)
            for(int j = i; j < s.length(); j += (2 * (numRows - 1))){
                // Append the character vertically down in the zigzag
                str.append(s.charAt(j));
                
                // For middle rows, append the diagonal character if it exists
                // Conditions:
                // i > 0 and i < numRows - 1 ensures it's not the first or last row
                // The diagonal character index is calculated as:
                // j + (full cycle length) - (2 * i)
                if(i > 0 && i < numRows - 1 && j + (2 * (numRows - 1)) - (2 * i) < s.length()){
                    str.append(s.charAt(j + (2 * (numRows - 1)) - (2 * i)));
                }
            }
        }
        
        // Convert StringBuilder to String and return the final zigzag converted string
        return str.toString();
    }
}
