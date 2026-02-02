class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        // Initialize result with the maximum possible long value
        long result = Long.MAX_VALUE;
        // This will hold the sum of the current window elements
        long windowsum = 0L;
        int n = nums.length;

        // TreeSet 'using' holds indices of elements currently considered in the window,
        // sorted by their nums values ascending, and by index if values are equal
        TreeSet<Integer> using = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

        // TreeSet 'waiting' holds indices of elements outside the current window,
        // also sorted by their nums values ascending, and by index if values are equal
        TreeSet<Integer> waiting = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

        // Initialize the window with the first dist+1 elements (indices 1 to dist+1)
        for (int i = 1; i <= dist + 1; i++) {
            using.add(i);
            windowsum += nums[i];
        }

        // Reduce the size of 'using' to k-1 by moving the largest elements to 'waiting'
        while (using.size() > k - 1) {
            int i = using.pollLast(); // Remove the largest element index from 'using'
            windowsum -= nums[i];     // Subtract its value from the window sum
            waiting.add(i);           // Add it to 'waiting'
        }

        // Update the result with the current window sum
        result = Math.min(result, windowsum);

        // Slide the window from left to right, starting from index 1 up to n - dist - 2
        for (int i = 1; i + dist + 1 < n; i++) {
            // Add the new element entering the window to 'waiting'
            waiting.add(i + dist + 1);

            if (using.contains(i)) {
                // If the element leaving the window is in 'using',
                // remove it and adjust the window sum accordingly
                windowsum -= nums[i];
                using.remove(i);

                // Move the smallest element from 'waiting' to 'using' to maintain size
                int j = waiting.pollFirst();
                windowsum += nums[j];
                using.add(j);
            } else {
                // If the element leaving the window is in 'waiting',
                // simply remove it from 'waiting'
                waiting.remove(i);

                // Check if we can optimize the window by swapping elements between 'using' and 'waiting'
                int j1 = waiting.first(); // smallest in waiting
                int j2 = using.last();    // largest in using

                // If the smallest waiting element is smaller than the largest using element,
                // swap them to minimize the window sum
                if (nums[j1] < nums[j2]) {
                    windowsum -= nums[j2];
                    using.remove(j2);
                    waiting.add(j2);

                    windowsum += nums[j1];
                    using.add(j1);
                    waiting.remove(j1);
                }
            }

            // Update the result with the minimum window sum found so far
            result = Math.min(result, windowsum);
        }

        // Add nums[0] to the result as per problem requirement and return
        return result + nums[0];
    }
}
