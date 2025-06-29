class Solution {
    public List<Integer> lexicalOrder(int n) {
        // Create a list to store the result
        List<Integer> result = new ArrayList<>();
        // Initialize count to 1, which is the starting point for lexical order
        int count = 1;

        // Loop until we have added n elements to the result
        for (int i = 0; i < n; i++) {
            // Add the current count to the result list
            result.add(count);
            // If multiplying count by 10 is still within the limit n, go deeper
            if (count * 10 <= n) {
                count *= 10;
            } else {
                // If count is greater than or equal to n, go back one level
                if (count >= n) {
                    count /= 10;
                }
                // Increment count to move to the next number
                count++;
                // Remove any trailing zeros by dividing by 10
                while (count % 10 == 0) {
                    count /= 10;
                }
            }
        }
        // Return the list of numbers in lexical order
        return result;
    }
}
