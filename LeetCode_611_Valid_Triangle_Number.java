class Solution {
    public int triangleNumber(int[] nums) {
        // Step 1: Sort the array to make it easier to apply the triangle inequality
        Arrays.sort(nums);

        int count = 0; // This will store the number of valid triangles

        // Step 2: Iterate from the end, treating nums[i] as the largest side
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;         // Start pointer at the beginning
            int right = i - 1;    // End pointer just before i

            // Step 3: Use two pointers to find valid pairs (nums[left], nums[right])
            while (left < right) {
                // If the sum of the two smaller sides is greater than the largest side,
                // then all pairs between left and right are valid
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left; // Add all valid pairs at once
                    right--;               // Move the right pointer left to check for more pairs
                } else {
                    left++;                // Otherwise, move the left pointer right to increase the sum
                }
            }
        }
        // Step 4: Return the total count of valid triangles
        return count;
    }
}
