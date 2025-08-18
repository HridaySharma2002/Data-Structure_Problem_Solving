class Solution {
    // Main method to check if the digits of n can be reordered to form a power of 2
    public boolean reorderedPowerOf2(int n) {
        // Get the sorted string of digits for the input number n
        String target = sortdigits(n);

        // Loop through all powers of 2 from 2^0 to 2^30 (since 2^31 exceeds int range)
        for(int i = 0; i < 31; i++) {
            // Calculate the current power of 2 using bit shifting (1 << i)
            int poweroftwo = 1 << i;

            // Sort the digits of the current power of 2 and compare with target
            if(sortdigits(poweroftwo).equals(target)) {
                // If a match is found, return true
                return true;
            }
        }
        // If no permutation matches any power of 2, return false
        return false;
    }

    // Helper method to return the sorted string of digits of a number
    private String sortdigits(int num) {
        // Convert the number to a character array of its digits
        char[] arr = String.valueOf(num).toCharArray();
        // Sort the character array to get a canonical form
        Arrays.sort(arr);
        // Return the sorted digits as a string
        return new String(arr);
    }
}
