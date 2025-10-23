class Solution {
    public boolean hasSameDigits(String s) {
        int iteration = 0; // Tracks the number of iterations performed
        char[] arr = s.toCharArray(); // Convert the input string to a character array for easy manipulation

        // Continue the process until only two digits remain
        while (arr.length - iteration != 2) {
            // For each pair of adjacent digits, replace the left one with the sum (modulo 10)
            for (int i = 0; i < arr.length - 1 - iteration; i++) {
                // Calculate the sum of the current digit and the next digit, modulo 10, and convert back to char
                arr[i] = (char)(((arr[i] - '0') + (arr[i + 1] - '0')) % 10 + '0');
            }
            iteration++; // Move to the next iteration, reducing the effective length by one
        }
        // After the loop, only two digits remain; check if they are the same
        return arr[0] == arr[1];
    }
}
