class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers: left at the start, right at the end of the array
        int left = 0;
        int right = height.length - 1;
        // Variable to keep track of the maximum area found so far
        int maxarea = 0;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the area formed between the two lines
            // The width is (right - left)
            // The height is the minimum of the two heights at left and right
            maxarea = Math.max(maxarea, (right - left) * Math.min(height[left], height[right]));

            // Move the pointer pointing to the shorter line inward,
            // because moving the taller line won't increase the area
            if (height[left] < height[right]) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }
        // Return the maximum area found
        return maxarea;
    }
}
