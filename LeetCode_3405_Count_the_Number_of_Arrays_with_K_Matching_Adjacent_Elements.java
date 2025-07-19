class Solution {
    // Define a constant MOD for modular arithmetic, commonly used in competitive programming
    static final int MOD = 1_000_000_007;

    // Function to compute the modular multiplicative inverse of 'a' under modulo 'mod'
    long modInverse(long a, long mod) {
        long res = 1; // Initialize result to 1
        long power = mod - 2; // According to Fermat's Little Theorem

        // Loop until power becomes 0
        while (power > 0) {
            // If power is odd, multiply the current base 'a' with result
            if ((power & 1) == 1) {
                res = res * a % mod; // Update result with modular multiplication
            }
            // Square the base 'a'
            a = a * a % mod;
            // Right shift power by 1 (equivalent to dividing by 2)
            power >>= 1;
        }
        return res; // Return the computed modular inverse
    }

    // Function to compute nCr (combinations) which calculates "n choose r"
    int nCr(int n, int r) {
        // If r is greater than n, return 0 (impossible to choose more elements than available)
        if (r > n) {
            return 0;
        }
        // If r is 0 or r equals n, there is exactly one way to choose
        if (r == 0 || r == n) {
            return 1;
        }

        long res = 1; // Initialize result to 1

        // Calculate nCr using the formula: nCr = n! / (r! * (n-r)!)
        for (int i = 1; i <= r; i++) {
            // Update result with the numerator part of the combination formula
            res = res * (n - r + i) % MOD;
            // Multiply by the modular inverse of i! to account for the denominator
            res = res * modInverse(i, MOD) % MOD;
        }
        return (int) res; // Return the result as an integer
    }

    // Function to perform binary exponentiation to compute a^b % MOD
    long bExpo(long a, long b) {
        long result = 1; // Initialize result to 1

        // Loop until b becomes 0
        while (b > 0) {
            // If b is odd, multiply the current base 'a' with result
            if ((b & 1) == 1) {
                result = result * a % MOD; // Update result with modular multiplication
            }
            // Square the base 'a'
            a = a * a % MOD;
            // Right shift b by 1 (equivalent to dividing by 2)
            b >>= 1;
        }
        return result; // Return the computed power
    }

    // Function to count the number of good arrays based on given parameters
    public int countGoodArrays(int n, int m, int k) {
        // Calculate the initial formula based on the number of choices for the first element
        long formula = m * bExpo(m - 1, n - (k + 1)) % MOD;
        // Update the formula by multiplying with the number of ways to choose k positions from n-1
        long updatedFormula = formula * nCr(n - 1, k) % MOD;
        return (int) updatedFormula; // Return the final count of good arrays as an integer
    }
}
