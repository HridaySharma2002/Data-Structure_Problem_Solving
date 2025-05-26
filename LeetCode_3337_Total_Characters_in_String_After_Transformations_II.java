class Solution {
    // Define a constant for the modulo operation to prevent overflow
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Array to hold the count of characters after transformations
        int[] count = new int[26]; 
        // Transition matrix to represent how characters transform into others
        int[][] transition = new int[26][26];

        // Fill the transition matrix based on the nums array
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                // Increment the count of transformations for each character
                transition[i][(i + j) % 26]++;
            }
        }

        // Calculate the result matrix raised to the power of t
        int[][] resultMatrix = matrixPower(transition, t);

        // Sum up the transformations for each character
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // Accumulate the counts from the result matrix
                count[i] = (count[i] + resultMatrix[i][j]) % MOD;
            }
        }

        // Calculate the total length of the transformed string
        long total = 0;
        for (char ch : s.toCharArray()) {
            // Add the count of transformations for each character in the original string
            total = (total + count[ch - 'a']) % MOD;
        }

        // Return the total length as an integer
        return (int) total;
    }

    // Method to multiply two matrices
    private int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                for (int j = 0; j < 26; j++) {
                    // Perform matrix multiplication and apply modulo
                    res[i][j] = (int)((res[i][j] + 1L * a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    // Method to compute the power of a matrix using exponentiation by squaring
    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[26][26];

        // Initialize result as the identity matrix
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }

        // Exponentiation by squaring
        while (power > 0) {
            if ((power & 1) == 1) {
                // Multiply the result by the current matrix if power is odd
                result = multiply(result, matrix);
            }
            // Square the matrix for the next iteration
            matrix = multiply(matrix, matrix);
            // Divide the power by 2
            power >>= 1;
        }

        return result;
    }
}
