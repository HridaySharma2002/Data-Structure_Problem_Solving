class Solution {
    public String addBinary(String a, String b) {
        // StringBuilder to efficiently build the resulting binary string
        StringBuilder sb = new StringBuilder();
        
        // Variable to keep track of carry during addition
        int carry = 0;
        
        // Start from the last character (least significant bit) of string 'a'
        int i = a.length() - 1;
        
        // Start from the last character (least significant bit) of string 'b'
        int j = b.length() - 1;
        
        // Loop until both strings are fully processed and no carry remains
        while (i >= 0 || j >= 0 || carry == 1) {
            // If there are still characters left in 'a', add its bit to carry
            if (i >= 0) {
                carry += a.charAt(i--) - '0';  // Convert char '0' or '1' to int 0 or 1
            }
            
            // If there are still characters left in 'b', add its bit to carry
            if (j >= 0) {
                carry += b.charAt(j--) - '0';  // Convert char '0' or '1' to int 0 or 1
            }
            
            // Append the least significant bit of carry to the result
            sb.append(carry % 2);
            
            // Update carry by dividing by 2 (either 0 or 1)
            carry /= 2;
        }
        
        // The result is built backwards, so reverse it before returning
        return sb.reverse().toString();
    }
}
