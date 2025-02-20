class MedianFinder {

    // Max-heap to store the smaller half of the numbers
    private PriorityQueue<Integer> maxheap;
    // Min-heap to store the larger half of the numbers
    private PriorityQueue<Integer> minheap;

    // Constructor to initialize the MedianFinder object
    public MedianFinder() {
        // Initialize maxheap with a custom comparator to create a max-heap
        maxheap = new PriorityQueue<>((a, b) -> b - a);
        // Initialize minheap (default is a min-heap)
        minheap = new PriorityQueue<>();
    }
    
    // Method to add a number to the data structure
    public void addNum(int num) {
        // Add the number to the max-heap first
        maxheap.offer(num);
        
        // Move the largest element from maxheap to minheap to maintain balance
        minheap.offer(maxheap.poll());
        
        // Ensure that maxheap has at least as many elements as minheap
        if (maxheap.size() < minheap.size()) {
            // Move the smallest element from minheap back to maxheap
            maxheap.offer(minheap.poll());
        }
    }
    
    // Method to find the median of all elements added so far
    public double findMedian() {
        // If maxheap has more elements, the median is the root of maxheap
        if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        }

        // If both heaps are of equal size, the median is the average of the roots
        return (maxheap.peek() + minheap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
