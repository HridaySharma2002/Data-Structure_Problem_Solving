class Solution {
    public int numOfWays(int n){
        // Define the modulo as 10^9 + 7 to prevent integer overflow
        int MOD = (int)1e9 + 7;

        // type1: Number of ways to color a row with two colors adjacent (ABA pattern)
        // type2: Number of ways to color a row with all different colors (ABC pattern)
        long type1 = 6; // For the first row, there are 6 ABA patterns
        long type2 = 6; // For the first row, there are 6 ABC patterns

        // Iterate from the second row to the nth row
        for (int i = 2; i <= n; i++) {
            // Calculate the number of ways for the next row based on previous row's patterns
            // nexttype1: 3 ways to transition from type1, 2 ways from type2
            long nexttype1 = (3 * type1 + 2 * type2) % MOD;
            // nexttype2: 2 ways to transition from type1, 2 ways from type2
            long nexttype2 = (2 * type1 + 2 * type2) % MOD;

            // Update type1 and type2 for the next iteration
            type1 = nexttype1;
            type2 = nexttype2;
        }

        // The total number of ways is the sum of both pattern types, modulo MOD
        return (int)((type1 + type2) % MOD);
    }
}
