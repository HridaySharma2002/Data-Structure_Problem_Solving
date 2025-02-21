class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Create a frequency map to count occurrences of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            // Update the frequency count for each number
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min-heap to keep track of the top k frequent elements
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Step 3: Iterate through the frequency map and populate the min-heap
        for (HashMap.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            // Add the number and its frequency as an array to the min-heap
            minheap.offer(new int[]{entry.getKey(), entry.getValue()});
            // If the size of the heap exceeds k, remove the least frequent element
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        // Step 4: Extract the top k frequent elements from the min-heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // Poll the heap to get the elements and store them in the result array
            result[i] = minheap.poll()[0];
        }

        return result; // Return the array of top k frequent elements
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution();
 * int[] result = obj.topKFrequent(nums, k);
 */
