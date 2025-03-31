class Solution {
public int firstMissingPositive(int[] nums) {
    // Get the length of the input array
    int n = nums.length;

    // Rearrange the elements in the array such that each positive integer x
    // is placed at index x-1 (1 should be at index 0, 2 at index 1, etc.)
    for (int i = 0; i < n; i++) {
        // Continue swapping until the current number is in its correct position
        // or it is out of the valid range (1 to n)
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            // Store the current number in a temporary variable
            int temp = nums[i];
            // Swap the current number with the number at its correct position
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
        }
    }

    // After rearranging, check for the first index that does not have the correct value
    for (int i = 0; i < n; i++) {
        // If the number at index i is not equal to i + 1, then i + 1 is the missing positive
        if (nums[i] != i + 1) {
            return i + 1; // Return the smallest missing positive number
        }
    }

    // If all numbers from 1 to n are present, return n + 1
    return n + 1;
}
}
