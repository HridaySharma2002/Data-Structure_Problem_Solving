class Solution {
    public int numberOfWays(String corridor) {
        // Define the modulo constant as 10^9 + 7 to avoid integer overflow
        int MOD = (int)1e9 + 7;

        // s0: Number of ways to partition the corridor with all seats grouped in pairs
        long s0 = 0;
        // s1: Number of ways where we have seen an odd number of seats in the current group
        long s1 = 0;
        // s2: Number of ways where we have seen an even number of seats in the current group (start with 1 way)
        long s2 = 1;

        // Iterate through each character in the corridor string
        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                // When we encounter a seat ('S'):
                // t stores the previous s1 value (ways with odd seats before this 'S')
                long t = s1;
                // s1 becomes the previous s2 (ways with even seats before this 'S')
                s1 = s2;
                // s2 becomes t (ways with odd seats before this 'S')
                s2 = t;
                // s0 is updated to t (ways to partition up to this point)
                s0 = t;
            } else {
                // When we encounter a plant ('P'):
                // We can extend the current group, so add s0 (ways to partition up to last seat pair)
                s2 = (s0 + s2) % MOD;
            }
        }
        // Return the number of ways to partition the corridor (must end with all seats grouped in pairs)
        return (int)s0;
    }
}
