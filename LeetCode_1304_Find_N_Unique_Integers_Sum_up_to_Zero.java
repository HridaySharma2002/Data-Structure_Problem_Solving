class Solution {
    // Method to return an array of n unique integers that sum up to zero
    public int[] sumZero(int n) {
        // Create an integer array of size n to store the result
        int result[] = new int[n];
        // Loop through each index from 0 to n-1
        for (int i = 0; i < n; i++) {
            // Assign values such that the sum of all elements is zero
            // The formula 2*i - n + 1 generates n unique integers that sum to zero
            result[i] = 2 * i - n + 1;
        }
        // Return the resulting array
        return result;
    }
}
