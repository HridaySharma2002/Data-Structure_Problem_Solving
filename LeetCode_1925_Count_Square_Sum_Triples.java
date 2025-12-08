class Solution {
    public int countTriples(int n) {
        int result = 0; // Initialize the result counter

        // Loop for the first leg 'i' of the triple, starting from 3 (smallest possible for a Pythagorean triple)
        // The upper bound is 3*n/4 for optimization, as larger values of i will not yield valid triples
        for (int i = 3; i <= 3 * n / 4; i++) {

            // Loop for the second leg 'j', starting from i+1 to avoid duplicate pairs (since (a, b, c) and (b, a, c) are both counted)
            for (int j = i + 1; j < n; j++) {

                // Calculate the sum of squares of i and j
                int sum = i * i + j * j;

                // Calculate the integer square root of the sum
                int k = (int) Math.sqrt(sum);

                // Check if k is within the allowed range (1 <= k <= n)
                if (k <= n) {
                    // Check if sum is a perfect square (i.e., k * k == sum)
                    if (k * k == sum) {
                        result += 2; // Count both (i, j, k) and (j, i, k) as valid triples
                    }
                } else {
                    // If k > n, further increasing j will only increase sum, so break out of the inner loop early
                    break;
                }
            }
        }
        // Return the total number of valid triples found
        return result;
    }
}
