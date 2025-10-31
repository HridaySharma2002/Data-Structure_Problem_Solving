class Solution {
    // Method to find two duplicate numbers in the array
    public int[] getSneakyNumbers(int[] nums) {
        // Boolean array to keep track of numbers we've seen so far
        boolean[] check = new boolean[nums.length];
        // Array to store the two duplicate numbers found
        int[] sneaky = new int[2];
        // Index for inserting found duplicates into sneaky array
        int j = 0;
        // Loop through each number in the input array
        for(int i = 0; i < nums.length; i++) {
            // If we've already seen this number, it's a duplicate
            if(check[nums[i]] == true) {
                sneaky[j++] = nums[i]; // Store duplicate in sneaky array
            } else {
                check[nums[i]] = true; // Mark this number as seen
            }
        }
        // Return the array containing the two duplicates
        return sneaky;
    }
}
