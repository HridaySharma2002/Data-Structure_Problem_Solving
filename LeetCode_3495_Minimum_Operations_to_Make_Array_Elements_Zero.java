class Solution {
    // Public method to calculate the minimum operations for multiple queries
    public long minOperations(int[][] queries) {
        long result = 0;  // Initialize the result accumulator
        
        // Iterate over each query [l, r]
        for (int[] q : queries) {
            long l = q[0];  // Left boundary of the query range
            long r = q[1];  // Right boundary of the query range
            
            // Calculate the weighted sum of numbers from l to r using stepsum
            long total = stepsum(r) - stepsum(l - 1);
            
            // Add half of the total (rounded up) to the result
            result += (total + 1) / 2;
        }
        
        return result;  // Return the final accumulated result
    }

    // Private helper method to calculate weighted sum from 1 to n
    private long stepsum(long n) {
        if (n <= 0) {
            return 0;  // Base case: no numbers to sum if n <= 0
        }
        
        long result = 0;  // Accumulator for the weighted sum
        long base = 1;    // Start of the current range
        long step = 1;    // Weight for the current range
        
        // Loop through ranges defined by powers of 4 until base exceeds n
        while (base <= n) {
            // Calculate how many numbers fall into the current range:
            // from 'base' to the smaller of 'n' or 'base*4 - 1'
            long count = Math.min(n, base * 4 - 1) - base + 1;
            
            // Add weighted count to the result
            result += count * step;
            
            // Move to the next range by multiplying base by 4
            base *= 4;
            
            // Increase the weight for the next range
            step++;
        }
        
        return result;  // Return the total weighted sum up to n
    }
}
