class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size(); // Get the size of the input list
        int increment = 1; // Tracks the length of the current increasing sequence
        int previncrement = 0; // Tracks the length of the previous increasing sequence
        int maxlen = 0; // Stores the maximum length found so far

        // Iterate through the list starting from the second element
        for (int i = 1; i < n; i++) {
            // If the current element is greater than the previous, increment the sequence length
            if (nums.get(i) > nums.get(i - 1)) {
                increment++;
            } else {
                // Sequence broke, store the previous increment and reset increment to 1
                previncrement = increment;
                increment = 1;
            }
            // Update maxlen with the maximum of current and previous increments
            // increment >> 1 is equivalent to increment / 2 (integer division)
            maxlen = Math.max(maxlen, Math.max(increment >> 1, Math.min(previncrement, increment)));
            // If we have found a sequence of at least length k, return true
            if (maxlen >= k) {
                return true;
            }
        }
        // If no such sequence is found, return false
        return false;
    }
}
