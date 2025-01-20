class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1]; // Step 1: Initialize the result array
        int index = 0; // Step 2: Initialize the index for the result array
        Deque<Integer> deque = new ArrayDeque<>(); // Step 3: Initialize the deque

        for (int i = 0; i < nums.length; i++) { // Step 4: Iterate through the array
            // Step 5: Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            // Step 6: Remove indices of elements that are less than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 7: Add the current index to the deque
            deque.offer(i);

            // Step 8: Store the maximum for the current window
            if (i >= k - 1) {
                max[index++] = nums[deque.peek()]; // The maximum is at the front of the deque
            }
        }
        return max; // Step 9: Return the result array
    }
}
