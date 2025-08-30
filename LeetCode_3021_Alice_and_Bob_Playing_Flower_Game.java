class Solution {
    public long flowerGame(int n, int m) {
        // The number of pairs where Alice wins is simply (n * m) / 2.
        // Why? Alice wins if the total number of flowers (x + y) is odd.
        // The number of odd (x + y) pairs in a rectangle [1, n] x [1, m]
        // is exactly half of all possible pairs (since half of the sums are odd).
        return (long)n*m/2;
    }
}
