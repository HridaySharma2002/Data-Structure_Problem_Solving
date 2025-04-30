class Solution {
    // Memoization table to store results of subproblems
    private int f[][];
    // Combination table to store values of C(n, k)
    private int c[][];
    // Length of the ideal arrays
    private int n;
    // Maximum value for elements in the ideal arrays
    private int m;
    // Constant for modulo operation to prevent overflow
    private static final int MOD = (int) 1e9 + 7;

    // Main method to calculate the number of ideal arrays
    public int idealArrays(int n, int maxValue) {
        this.n = n; // Set the length of the ideal arrays
        this.m = maxValue; // Set the maximum value for elements
        // Initialize the memoization table with size (maxValue + 1) x 16
        this.f = new int[maxValue + 1][16];
        // Fill the memoization table with -1 to indicate uncomputed states
        for (int[] row : f) {
            Arrays.fill(row, -1);
        }
        // Initialize the combination table
        c = new int[n][16];
        // Fill the combination table using dynamic programming
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i && j < 16; j++) {
                // C(i, 0) = 1, C(i, j) = C(i-1, j) + C(i-1, j-1)
                c[i][j] = j == 0 ? 1 : (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }

        // Variable to store the final result
        int result = 0;
        // Iterate through each possible starting value from 1 to maxValue
        for (int i = 1; i <= m; i++) {
            // Add the number of ideal arrays starting with value i
            result = (result + dfs(i, 1)) % MOD;
        }

        // Return the total count of ideal arrays
        return result;
    }

    // Recursive method to calculate the number of ideal arrays starting with value i
    private int dfs(int i, int count) {
        // Check if the result is already computed
        if (f[i][count] != -1) {
            return f[i][count];
        }
        // Start with the number of ways to choose (count - 1) elements from (n - 1)
        int res = c[n - 1][count - 1];
        // If we can still add more elements to the array
        if (count < n) {
            // Explore multiples of i (i.e., 2*i, 3*i, ...) as potential next elements
            for (int k = 2; k * i <= m; k++) {
                // Add the number of ideal arrays formed by the next element
                res = (res + dfs(k * i, count + 1)) % MOD;
            }
        }
        // Store the computed result in the memoization table
        f[i][count] = res;
        return res; // Return the result
    }
}
