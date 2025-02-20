class KthLargest {
    private int k; // The kth position we are interested in
    private PriorityQueue<Integer> minheap; // Min-heap to store the top k largest elements

    // Constructor to initialize the KthLargest object
    public KthLargest(int k, int[] nums) {
        this.k = k; // Set the kth value
        minheap = new PriorityQueue<>(k); // Initialize the min-heap with a capacity of k

        // Add initial numbers to the min-heap
        for (int num : nums) {
            add(num); // Use the add method to maintain the size of the heap
        }
    }
    
    // Method to add a new score and return the kth largest element
    public int add(int val) {
        minheap.offer(val); // Add the new value to the min-heap

        // If the size of the heap exceeds k, remove the smallest element
        if (minheap.size() > k) {
            minheap.poll(); // Remove the smallest element to maintain only k largest elements
        }

        // The root of the min-heap is the kth largest element
        return minheap.peek(); // Return the kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
