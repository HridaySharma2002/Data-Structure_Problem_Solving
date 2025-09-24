class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // If the numerator is zero, the result is always "0"
        if(numerator == 0){
            return "0";
        }

        // Use StringBuilder to efficiently build the result string
        StringBuilder fraction = new StringBuilder();

        // If the result is negative, append the minus sign
        // (XOR: true if only one of numerator or denominator is negative)
        if(numerator < 0 ^ denominator < 0){
            fraction.append("-");
        }

        // Convert numerator and denominator to long and take absolute values
        // This avoids overflow issues (e.g., Integer.MIN_VALUE)
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        // Append the integer part of the division
        fraction.append(dividend / divisor);

        // Calculate the initial remainder
        long remainder = dividend % divisor;

        // If there is no remainder, return the result as there is no fractional part
        if(remainder == 0){
            return fraction.toString();
        }

        // There is a fractional part, so append the decimal point
        fraction.append(".");

        // Use a map to store previously seen remainders and their positions in the result
        Map<Long, Integer> map = new HashMap<>();

        // Loop until the remainder becomes zero or a repeating remainder is found
        while(remainder != 0){
            // If the remainder is already seen, a repeating cycle is detected
            if(map.containsKey(remainder)){
                // Insert '(' at the position where this remainder first appeared
                fraction.insert(map.get(remainder), "(");
                // Append ')' at the end to close the repeating part
                fraction.append(")");
                break;
            }
            // Store the current remainder and its position in the result string
            map.put(remainder, fraction.length());

            // Multiply remainder by 10 to get the next digit
            remainder *= 10;
            // Append the next digit of the fractional part
            fraction.append(remainder / divisor);
            // Update the remainder
            remainder %= divisor;
        }

        // Return the final result as a string
        return fraction.toString();
    }
}
