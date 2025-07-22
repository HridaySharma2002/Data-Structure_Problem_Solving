class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // Initialize a list to store the result indices
        List<Integer> result = new ArrayList<>();
        int left = 0; // Left pointer for the sliding window
        int right = 0; // Right pointer for the sliding window
        int len = nums.length; // Length of the input array

        // Loop until both pointers are within the bounds of the array
        while (left < len && right < len) {
            // If the current right pointer does not point to the key, move right pointer
            if (nums[right] != key) {
                right++;
            } 
            // If the left pointer is too far from the right pointer, move left pointer
            else if (left < right - k) {
                left++;
            } 
            // If the left pointer is within the valid range, add it to the result
            else if (left <= right + k) {
                result.add(left++);
            } 
            // If none of the above conditions are met, move the right pointer
            else {
                right++;
            }
        }
        // Return the list of indices that are k-distance from the key
        return result;
    }
}
