class Solution {
    public long countGoodIntegers(int n, int k) {
        // Create an array to store factorial values from 0 to n
        long fac[] = new long[n + 1];
        fac[0] = 1; // 0! is 1
        // Calculate factorials for all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i; // n! = (n-1)! * n
        }

        long count = 0; // Initialize the count of good integers
        Set<String> vis = new HashSet<>(); // Set to track unique permutations
        // Calculate the base for generating the first half of palindromic numbers
        int base = (int) Math.pow(10, (n - 1) / 2);
        
        // Iterate through all possible first halves of palindromic numbers
        for (int i = base; i < base * 10; i++) {
            String s = String.valueOf(i); // Convert the number to a string
            StringBuilder sb = new StringBuilder(s).reverse(); // Reverse the string
            s += sb.substring(n % 2); // Append the reversed string (handle odd/even length)

            // Check if the constructed palindrome is divisible by k
            if (Long.parseLong(s) % k != 0) {
                continue; // Skip if not divisible
            }

            char[] arr = s.toCharArray(); // Convert the palindrome to a character array
            Arrays.sort(arr); // Sort the characters to facilitate unique counting
            String t = new String(arr); // Create a string from the sorted characters
            
            // Skip if this permutation has already been processed
            if (vis.contains(t)) {
                continue;
            }
            vis.add(t); // Mark this permutation as seen

            int[] cnt = new int[10]; // Array to count occurrences of each digit (0-9)
            for (char c : arr) {
                cnt[c - '0']++; // Increment the count for the digit
            }

            // Calculate the number of valid permutations
            long res = (n - cnt[0]) * fac[n - 1]; // Leading digit cannot be zero
            for (int x : cnt) {
                res /= fac[x]; // Divide by the factorial of the frequency of each digit
            }

            count += res; // Add the result to the total count
        }

        return count; // Return the total count of good integers
    }
}
