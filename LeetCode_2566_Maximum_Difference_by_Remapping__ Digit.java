class Solution {
    public int minMaxDifference(int num) {
        // Convert the integer num to a string for easy manipulation of its digits
        String numStr = String.valueOf(num);
        
        // Initialize maxnum and minnum to the original number
        int maxnum = num;
        int minnum = num;

        // Iterate over all possible digits from '0' to '9' for remapping
        for (char d1 = '0'; d1 <= '9'; d1++) {
            for (char d2 = '0'; d2 <= '9'; d2++) {
                // Ensure that we are not remapping a digit to itself
                if (d1 != d2) {
                    // StringBuilder to construct the new maximum and minimum numbers
                    StringBuilder maxAppend = new StringBuilder();
                    StringBuilder minAppend = new StringBuilder();

                    // Iterate through each character in the string representation of num
                    for (char c : numStr.toCharArray()) {
                        // For maximum value: replace occurrences of d1 with d2
                        if (c == d1) {
                            maxAppend.append(d2); // Remap d1 to d2
                        } else {
                            maxAppend.append(c); // Keep the original digit
                        }

                        // For minimum value: replace occurrences of d2 with d1
                        if (c == d2) {
                            minAppend.append(d1); // Remap d2 to d1
                        } else {
                            minAppend.append(c); // Keep the original digit
                        }
                    }
                    // Convert the constructed strings to integers and update maxnum and minnum
                    maxnum = Math.max(maxnum, Integer.parseInt(maxAppend.toString()));
                    minnum = Math.min(minnum, Integer.parseInt(minAppend.toString()));
                }
            }
        }
        // Return the difference between the maximum and minimum values found
        return maxnum - minnum;
    }
}
