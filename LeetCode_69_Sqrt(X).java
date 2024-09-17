class Solution {
    public int mySqrt(int x) {
    // Initialize the binary search range
    int left = 1, right = x;
    int result = 0;
    
    // Perform binary search
    while (left <= right) {
        int mid = left + (right - left) / 2; // To prevent overflow
        long midSquared = (long) mid * mid; // Use long to avoid overflow

        if (midSquared == x) {
            return mid; // Found exact square root
        } else if (midSquared < x) {
            result = mid; // Update result to the latest valid mid
            left = mid + 1; // Search in the right half
        } else {
            right = mid - 1; // Search in the left half
        }
    }
    
    return result; // Return the largest integer whose square is <= x

    }
}
