class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        // Flags to mark if each phase (increase, decrease, increase) has occurred
        boolean bp1 = false; // first increasing phase
        boolean bp2 = false; // decreasing phase
        boolean bp3 = false; // second increasing phase

        int start = 1; // start from second element to compare with previous

        // First phase: strictly increasing sequence
        while (start < n && nums[start] > nums[start - 1]) {
            bp1 = true; // mark that first increasing phase exists
            start++;
        }

        // Second phase: strictly decreasing sequence
        while (start < n && nums[start] < nums[start - 1]) {
            bp2 = true; // mark that decreasing phase exists
            start++;
        }

        // Third phase: strictly increasing sequence again
        while (start < n && nums[start] > nums[start - 1]) {
            bp3 = true; // mark that second increasing phase exists
            start++;
        }

        // Return true only if we reached the end of the array
        // and all three phases occurred in order
        return start == n && bp1 && bp2 && bp3;
    }
}
