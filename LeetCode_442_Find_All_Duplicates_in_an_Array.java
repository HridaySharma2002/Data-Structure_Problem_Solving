class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();  // List to store duplicates found
        
        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);  // Get the absolute value of current number
            
            // Use the value as an index (num - 1) to check the sign of the element at that index
            // If positive, mark it negative to indicate this number has been seen once
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;  // Mark visited by negating the value at index (num - 1)
            } else {
                // If already negative, it means we've seen this number before, so it's a duplicate
                result.add(num);
            }
        }
        
        return result;  // Return the list of duplicates
    }
}
