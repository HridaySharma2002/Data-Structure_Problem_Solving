class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalsum = 0; // To store the sum of absolute values of all elements
        int minabsvalue = Integer.MAX_VALUE; // To track the smallest absolute value in the matrix
        int negativecount = 0; // To count how many negative numbers are in the matrix

        // Iterate through each element of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int value = matrix[i][j];
                totalsum += Math.abs(value); // Add the absolute value of the current element to totalsum

                if (value < 0) {
                    negativecount++; // Increment count if the current element is negative
                }

                // Update minabsvalue if the absolute value of the current element is smaller
                minabsvalue = Math.min(minabsvalue, Math.abs(value));
            }
        }

        // If the count of negative numbers is even,
        // we can flip signs in pairs to make all elements positive,
        // so the maximum sum is just the sum of absolute values
        if (negativecount % 2 == 0) {
            return totalsum;
        } else {
            // If the count of negative numbers is odd,
            // one element must remain negative.
            // To maximize the sum, keep the negative sign on the element with the smallest absolute value.
            // Since totalsum includes the absolute value of that element as positive,
            // subtract twice that smallest absolute value to correct the sum.
            return totalsum - 2 * minabsvalue;
        }
    }
}
