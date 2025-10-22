class Solution {
    // Returns the maximum frequency of any element after performing up to numOperations,
    // where each operation can add any integer in [-k, k] to a unique element.
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // If there's only one element, its frequency is 1 by default.
        if(nums.length == 1){
            return 1;
        }
        // Sort the array to make it easier to use sliding window technique.
        Arrays.sort(nums);

        // Compute the initial right boundary: the best possible frequency without any operation,
        // or limited by numOperations.
        int right = Math.min(numOperations, prepareMaxNums(nums, k));
        int ind = 0;   // Left pointer for the sliding window
        int left = 0;  // Right pointer for the sliding window
        int freq = 0;  // Current frequency of the same number

        // Iterate through each element in the sorted array
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            // If current number is same as previous, increment frequency, else reset to 1.
            freq = (i > 0 && nums[i] == nums[i-1]) ? freq + 1 : 1;
            int min = num - k; // Minimum value that can be converted to num with one operation
            int max = num + k; // Maximum value that can be converted to num with one operation

            // Move the window [ind, left) to include all numbers that can be converted to num
            while(true){
                if(ind < nums.length && nums[ind] < min){
                    ind++; // Move left pointer forward if value is too small
                }else if(left < nums.length && nums[left] <= max){
                    left++; // Move right pointer forward if value is within range
                }else{
                    break; // Window is set
                }
            }
            // Update the answer: max of current and possible frequency using available operations
            right = Math.max(right, Math.min(freq + numOperations, left - ind));
        }
        return right;
    }

    // Helper function to compute the maximum number of elements that can be made equal
    // by changing each element by at most k (without exceeding array bounds).
    private int prepareMaxNums(int[] nums, int k){
        int left = 0;
        int right = 0;
        // For each element, find the farthest element within 2*k range
        for(int i = 0; i < nums.length; i++){
            int target = nums[i] + 2 * k; // Max value reachable from nums[i] with two-sided k
            // Move left pointer to include all numbers <= target
            while(left < nums.length && nums[left] <= target){
                left++;
            }
            // Update the maximum window size found so far
            right = Math.max(right, left - i);
        }
        return right;
    }
}
