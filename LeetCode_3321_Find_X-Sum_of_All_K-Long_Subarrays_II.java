class Solution {
    // TreeSet to keep track of the top 'x' elements in the current window.
    // Each element is an int[]: [frequency, value], sorted by frequency, then value.
    private TreeSet<int[]> topelements = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    
    // TreeSet to keep the remaining elements outside the top 'x' in the window.
    private TreeSet<int[]> remaining = new TreeSet<>(topelements.comparator());
    
    // Map to store the frequency of each value in the current window.
    private Map<Integer, Integer> map = new HashMap<>();
    
    // Current sum of the top 'x' elements (frequency * value).
    private long currentsum;

    /**
     * Finds the sum of the top 'x' elements (by frequency and value) in every sliding window of size 'k'.
     * @param nums The input array.
     * @param k The window size.
     * @param x The number of top elements to sum.
     * @return An array of sums for each window.
     */
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long result[] = new long[n - k + 1];
        for (int i = 0; i < n; i++) {
            int currentvalue = nums[i];
            // Remove the current value from the sets before updating its frequency.
            removeFromSets(currentvalue);
            // Update the frequency map for the current value.
            map.merge(currentvalue, 1, Integer::sum);
            // Add the updated value back to the appropriate set.
            addToSets(currentvalue);

            int windowindex = i - k + 1;
            if (windowindex < 0) {
                // Skip until the first full window is formed.
                continue;
            }

            // Move elements from 'remaining' to 'topelements' until 'topelements' has 'x' elements.
            while (!remaining.isEmpty() && topelements.size() < x) {
                int[] element = remaining.pollLast();
                currentsum += 1L * element[0] * element[1];
                topelements.add(element);
            }
            // If 'topelements' has more than 'x' elements, move the smallest out.
            while (topelements.size() > x) {
                int[] element = topelements.pollFirst();
                currentsum -= 1L * element[0] * element[1];
                remaining.add(element);
            }
            // Store the current sum for this window.
            result[windowindex] = currentsum;

            // Prepare to slide the window: remove the outgoing element.
            removeFromSets(nums[windowindex]);
            map.merge(nums[windowindex], -1, Integer::sum);
            addToSets(nums[windowindex]);
        }
        return result;
    }

    /**
     * Adds a value (with its current frequency) to the appropriate set.
     * @param value The value to add.
     */
    private void addToSets(int value) {
        if (!map.containsKey(value)) {
            return;
        }
        int[] elementpair = new int[]{map.get(value), value};
        // If the element should be in 'topelements', add it there and update the sum.
        if (!topelements.isEmpty() && topelements.comparator().compare(topelements.first(), elementpair) < 0) {
            topelements.add(elementpair);
            currentsum += 1L * elementpair[0] * elementpair[1];
        } else {
            // Otherwise, add it to 'remaining'.
            remaining.add(elementpair);
        }
    }

    /**
     * Removes a value (with its current frequency) from the sets.
     * @param value The value to remove.
     */
    private void removeFromSets(int value) {
        if (!map.containsKey(value)) {
            return;
        }
        int[] elementpair = new int[]{map.get(value), value};
        // Remove from the appropriate set and update the sum if needed.
        if (topelements.contains(elementpair)) {
            topelements.remove(elementpair);
            currentsum -= 1L * elementpair[0] * elementpair[1];
        } else {
            remaining.remove(elementpair);
        }
    }
}
