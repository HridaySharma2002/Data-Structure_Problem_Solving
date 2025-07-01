class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1; // Start with the first number in lexicographical order
        k--; // Decrement k to convert to 0-based index

        // Loop until we find the k-th number
        while (k > 0) {
            // Count how many numbers are in the current prefix
            long count = countNumbers(n, current);
            if (count <= k) {
                // If there are not enough numbers, move to the next prefix
                current++; // Increment current to check the next number
                k -= count; // Decrease k by the count of numbers skipped
            } else {
                // If there are enough numbers, go deeper in the tree
                current *= 10; // Move to the next level in the lexicographical order
                k--; // Decrement k as we are going deeper
            }
        }

        return current; // Return the k-th number in lexicographical order
    }

    private long countNumbers(int n, long prefix) {
        long count = 0; // Initialize count of numbers with the current prefix
        long first = prefix; // The first number with the current prefix
        long last = prefix + 1; // The first number with the next prefix

        // Count numbers in the range defined by the current prefix
        while (first <= n) {
            // Count how many numbers can be formed with the current prefix
            count += Math.min(n + 1, last) - first; // Count numbers in the range
            first *= 10; // Move to the next level (e.g., from 1 to 10)
            last *= 10; // Move to the next level (e.g., from 2 to 20)
        }

        return count; // Return the total count of numbers with the current prefix
    }
}
