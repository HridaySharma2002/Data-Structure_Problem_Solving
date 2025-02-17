class Solution {
    // Method to find the k-th largest element in an array
    public int findKthLargest(int[] nums, int k) {
        // Create a max-heap using a PriorityQueue
        // The comparator (a, b) -> b - a ensures that the largest element has the highest priority
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements from the input array to the priority queue
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        
        // The position we want to reach in the priority queue (0-based index)
        int desire_position = k - 1;
        
        // Remove elements from the priority queue until we reach the desired position
        while (desire_position > 0) {
            pq.remove(); // Remove the largest element
            desire_position--; // Decrement the desired position
        }

        // The k-th largest element will now be at the head of the priority queue
        return pq.peek(); // Return the k-th largest element
    }
}
