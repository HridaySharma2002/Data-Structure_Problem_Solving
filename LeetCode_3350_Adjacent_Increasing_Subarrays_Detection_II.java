class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        // currentincrement tracks the length of the current strictly increasing subarray
        int currentincrement = 1;
        // previncrement stores the length of the previous increasing subarray segment
        int previncrement = 0;
        // result stores the maximum length found so far according to the problem's criteria
        int result = 0;

        // Iterate through the list starting from the second element
        for (int i = 1; i < nums.size(); i++) {
            // Check if current element is greater than the previous element
            if (nums.get(i) > nums.get(i - 1)) {
                // If yes, increment the length of the current increasing subarray
                currentincrement++;
            } else {
                // Otherwise, reset previncrement to currentincrement and start a new count
                previncrement = currentincrement;
                currentincrement = 1;
            }

            // Find the minimum between previncrement and currentincrement
            int min = previncrement < currentincrement ? previncrement : currentincrement;
            // Calculate maxlen as the maximum between half of currentincrement (right-shift by 1) and min
            int maxlen = (currentincrement >> 1) > min ? (currentincrement >> 1) : min;

            // Update result if maxlen is greater than the current result
            if (maxlen > result) {
                result = maxlen;
            }
        }

        // Return the maximum length found
        return result;
    }
}
