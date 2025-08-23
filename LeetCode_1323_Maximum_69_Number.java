class Solution {
    public int maximum69Number(int num) {
        // Convert the integer num to a String, then to a char array to manipulate individual digits
        char digits[] = String.valueOf(num).toCharArray();

        // Iterate through each digit in the array
        for (int i = 0; i < digits.length; i++) {
            // Check if the current digit is '6'
            if (digits[i] == '6') {
                // Change the first '6' found to '9' to maximize the number
                digits[i] = '9';
                // Break after changing the first '6' to ensure only one digit is changed
                break;
            }
        }

        // Convert the modified char array back to a String, then parse it to an integer and return
        return Integer.parseInt(new String(digits));
    }
}
