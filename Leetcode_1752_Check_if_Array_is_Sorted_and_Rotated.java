class Solution {
    public boolean check(int[] nums) {
        int countOutOfOrder = 0;
        int n = nums.length;
      
        // Iterate over the elements of the array.
        for (int i = 0; i < n; ++i) {
            // Check if the current element is greater than the next element 
            // The next element of the last item is the first item, hence the modulo operation.
            if (nums[i] > nums[(i + 1) % n]) {
                // Increment the out of order count.
                ++countOutOfOrder;
            }
        }
      
        // The array is non-decreasing if there is at most one out-of-order pair.
        return countOutOfOrder <= 1;
    }
}
