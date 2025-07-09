class Solution {
    // Method to calculate the maximum difference between two numbers
    // derived from the original number by changing its digits.
    public int maxDiff(int num) {
        // Convert the integer num to its string representation
        final String s = String.valueOf(num);
        
        // Find the index of the first digit that is not '9'
        final int firstNot9 = firstNot(s, '9', '9');
        
        // Find the index of the first digit that is neither '0' nor '1'
        final int firstNot01 = firstNot(s, '0', '1');
        
        // Create the maximum number by replacing the first non-'9' digit with '9'
        final String a = s.replace(s.charAt(firstNot9), '9');
        
        // Create the minimum number by replacing the first non-'0' digit with '0'
        // If the first non-'0' digit is at index 0, replace it with '1' to avoid leading zeros
        final String b = s.replace(s.charAt(firstNot01), firstNot01 == 0 ? '1' : '0');
        
        // Parse the strings back to integers and return the difference
        return Integer.parseInt(a) - Integer.parseInt(b);
    }

    // Helper method to find the index of the first character in the string
    // that is not equal to either of the specified characters a or b.
    private int firstNot(final String s, char a, char b) {
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If the current character is not equal to a or b, return its index
            if (s.charAt(i) != a && s.charAt(i) != b) {
                return i;
            }
        }
        // If all characters are either a or b, return 0
        return 0;
    }
}
