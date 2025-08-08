class Solution {
    // Method to count the number of hills and valleys in the array
    public int countHillValley(int[] nums) {
        int total = 0; // Initialize the counter for hills and valleys
        int left = 0;  // 'left' keeps track of the last unique element's index

        // Iterate through the array, skipping the first and last elements
        for (int i = 1; i < nums.length - 1; i++) {
            // Only consider the current element if it's different from the next one
            if (nums[i] != nums[i + 1]) {
                // Check if current element is a hill or a valley
                // Hill: greater than both neighbors
                // Valley: less than both neighbors
                if ((nums[i] > nums[left] && nums[i] > nums[i + 1]) ||
                    (nums[i] < nums[left] && nums[i] < nums[i + 1])) {
                    total++; // Increment the counter if it's a hill or valley
                }
                left = i; // Update 'left' to the current index for the next iteration
            }
        }
        return total; // Return the total count of hills and valleys
    }
}
