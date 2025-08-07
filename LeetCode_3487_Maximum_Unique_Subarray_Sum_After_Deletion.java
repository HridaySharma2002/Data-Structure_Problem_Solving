class Solution {
    // Method to calculate the maximum sum as per the described logic
    public int maxSum(int[] nums) {
        // Assume all numbers are negative initially
        boolean negative = true;
        // Initialize maxvalue to the smallest possible integer
        int maxvalue = Integer.MIN_VALUE;
        
        // First loop: Check if there is any non-negative number and find the maximum value
        for (int num : nums) {
            if (num >= 0) {
                negative = false; // Found a non-negative number
            }
            if (num > maxvalue) {
                maxvalue = num; // Update maxvalue if current num is greater
            }
        }
        
        // If all numbers are negative, return the maximum value (the least negative)
        if (negative) {
            return maxvalue;
        }

        // Use a HashSet to store unique numbers from the array
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num); // Add each number to the set (duplicates are ignored)
        }

        int sum = 0;
        // Sum only the positive unique numbers
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }

        // Return the sum of unique positive numbers
        return sum;
    }
}
