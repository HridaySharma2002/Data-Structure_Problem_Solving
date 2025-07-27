class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0; // Initialize the shift counter to track how many times 'a' is shifted
        List<Long> lengths = new ArrayList<>(); // List to store lengths of the string after each operation
        long length = 1; // Start with an initial length of 1 (the character 'a')

        // Calculate the lengths of the string after each operation
        for (int op : operations) {
            length *= 2; // Each operation doubles the length of the string
            lengths.add(length); // Store the current length in the list
            if (length >= k) { // If the current length is greater than or equal to k, we can stop
                break;
            }
        }

        // Determine the k-th character by working backwards through the operations
        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2; // Calculate half of the current length
            int op = operations[i]; // Get the operation corresponding to the current length

            // Check if k is in the second half of the string
            if (k > half) {
                k -= half; // Adjust k to reflect its position in the second half
                if (op == 1) { // If the operation was a shift operation
                    shift++; // Increment the shift counter
                }
            }
            // If k is in the first half, we do nothing and continue to the next operation
        }

        // Calculate the final character based on the total shifts
        return (char) ((('a' - 'a' + shift) % 26) + 'a'); // Return the character after applying the shifts
    }
}
