class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length; // Length of the input array
        int ones = 0;        // Counter for elements that are already 1
        int g = 0;           // Variable to store the GCD of all elements

        // First pass: count the number of 1s and compute the GCD of the entire array
        for (int num : nums) {
            if (num == 1) {
                ones++;      // Increment count if the element is 1
            }
            g = gcd(g, num); // Update the GCD with the current element
        }

        // If there are any 1s in the array, each non-1 can be converted to 1 in one operation
        if (ones > 0) {
            return n - ones; // Minimum operations is the number of non-1 elements
        }

        // If the GCD of the entire array is greater than 1, it's impossible to make all elements 1
        if (g > 1) {
            return -1;
        }

        // Otherwise, find the shortest subarray whose GCD is 1
        int minlen = n; // Initialize with the maximum possible length
        for (int i = 0; i < n; i++) {
            int currentgcd = 0;
            for (int j = i; j < n; j++) {
                currentgcd = gcd(currentgcd, nums[j]); // Compute GCD for subarray nums[i..j]
                if (currentgcd == 1) {
                    minlen = Math.min(minlen, j - i + 1); // Update minimum length if GCD is 1
                    break; // No need to check longer subarrays starting at i
                }
            }
        }

        // The answer is the length of the shortest subarray (to create the first 1)
        // plus the number of remaining elements (to propagate 1 to all elements)
        return minlen + n - 2;
    }

    // Helper function to compute GCD of two numbers using the Euclidean algorithm
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
