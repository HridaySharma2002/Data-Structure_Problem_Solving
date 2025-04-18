class Solution {
    // This method calculates the number of powerful integers in the range [start, finish]
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // Convert the suffix string to a long integer
        long suffix = Long.valueOf(s);
        
        // Initialize increment as 10, which will be used to shift the prefix
        long increment = 10L;

        // Calculate increment as 10 raised to the power of the length of the suffix
        for (int i = 1; i < s.length(); i++) {
            increment *= 10L; // Increment = 10 ^ s.length()
        }

        // Calculate the total powerful integers in the range [start, finish]
        // by subtracting the count of powerful integers up to (start - 1) from those up to finish
        return countPowerfulIntegers(finish, suffix, increment, limit) - countPowerfulIntegers(start - 1, suffix, increment, limit);
    }

    // This method counts the number of powerful integers less than or equal to upperBound
    private long countPowerfulIntegers(long upperBound, long suffix, long increment, int limit) {
        // Initialize count based on whether upperBound is greater than or equal to the suffix
        long count = upperBound % increment < suffix ? 0 : 1;

        // Reduce upperBound by the increment factor to remove the suffix
        upperBound /= increment;

        // Initialize digitMultiplier to track the place value of digits
        long digitMultiplier = 1;

        // Process each digit of the upperBound
        while (upperBound > 0L) {
            long digit = upperBound % 10; // Get the last digit
            upperBound /= 10; // Remove the last digit

            // If the digit exceeds the limit, all lower powerful integers are lost
            if (digit > limit) {
                count = (limit + 1) * digitMultiplier; // Count all combinations for this digit place
            } else {
                count += digit * digitMultiplier; // Add the valid combinations for this digit
            }

            // Update the digitMultiplier for the next digit place
            digitMultiplier *= (limit + 1);
        }

        // Return the total count of powerful integers found
        return count;
    }
}
