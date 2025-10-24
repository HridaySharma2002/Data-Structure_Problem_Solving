class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> list = new ArrayList<>(); // List to store all generated beautiful numbers
        generate(0, new int[10], list); // Generate all beautiful numbers up to a limit
        Collections.sort(list); // Sort the list to find the smallest number greater than n
        for (int num : list) {
            if (num > n) {
                return num; // Return the first beautiful number greater than n
            }
        }
        return -1; // Return -1 if no such number is found (should not happen given constraints)
    }

    // Recursive method to generate beautiful numbers
    private void generate(long num, int[] count, List<Integer> list) {
        // If current number is positive and beautiful, add it to the list
        if (num > 0 && isBeautiful(count)) {
            list.add((int) num);
        }
        // Stop recursion if number exceeds the upper bound (1224444)
        if (num > 1224444) {
            return;
        }
        // Try to append digits 1 to 7 to the current number
        for (int d = 1; d <= 7; d++) {
            // Only add digit d if it has been used less than d times so far
            if (count[d] < d) {
                count[d]++;
                generate(num * 10 + d, count, list); // Recurse with new number and updated count
                count[d]--; // Backtrack: remove the digit count after recursion
            }
        }
    }

    // Check if the current count array represents a beautiful number
    private boolean isBeautiful(int[] count) {
        // A number is beautiful if for every digit d used, count[d] == d
        for (int d = 1; d <= 7; d++) {
            if (count[d] != 0 && count[d] != d) {
                return false; // If count doesn't match digit value, not beautiful
            }
        }
        return true; // All digits satisfy the beautiful condition
    }
}
