class Solution {
    public String largestGoodInteger(String num) {
        // Initialize a variable to keep track of the largest good integer found so far
        String largest = "";
        
        // Loop through the string, stopping at length - 2 to avoid out-of-bounds errors
        for (int i = 0; i + 2 < num.length(); i++) {
            // Check if the current character and the next two characters are the same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                // If a good integer is found, compare it with the current largest
                // Update 'largest' if the new substring is greater
                largest = largest.compareTo(num.substring(i, i + 3)) > 0 ? largest : num.substring(i, i + 3);
            }
        }
        
        // Return the largest good integer found, or an empty string if none found
        return largest;
    }
}
