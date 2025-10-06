class Solution {
    public int removeElement(int[] nums, int val) {
        // Initialize a pointer 'ind' to keep track of the position to overwrite
        int ind = 0;
        
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to 'val'
            if (nums[i] != val) {
                // Copy the current element to the position 'ind'
                nums[ind] = nums[i];
                // Move 'ind' to the next position
                ind++;
            }
            // If nums[i] == val, do nothing (skip this element)
        }
        
        // After the loop, 'ind' is the new length of the array without 'val'
        return ind;
    }
}
