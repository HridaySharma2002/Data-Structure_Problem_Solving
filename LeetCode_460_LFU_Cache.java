class LFUCache {
    final int capacity; // Maximum capacity of the cache
    int curSize; // Current size of the cache
    int minfrequency; // Minimum frequency of access among the keys
    Map<Integer, DLLNode> cache; // Map to store key-node pairs for O(1) access
    Map<Integer, DoubleLinkedList> frequencyMap; // Map to store frequency and corresponding nodes

    // Constructor to initialize the LFUCache with a specified capacity
    public LFUCache(int capacity) {
        this.capacity = capacity; // Set the capacity
        this.curSize = 0; // Initialize current size to 0
        this.minfrequency = 0; // Initialize minimum frequency to 0
        this.cache = new HashMap<>(); // Initialize the cache map
        this.frequencyMap = new HashMap<>(); // Initialize the frequency map
    }
    
    // Method to retrieve a value by key
    public int get(int key) {
        DLLNode curNode = cache.get(key); // Get the node associated with the key
        if (curNode == null) {
            return -1; // Return -1 if the key is not found
        }
        updateNode(curNode); // Update the frequency of the accessed node
        return curNode.value; // Return the value of the node
    }
    
    // Method to add a key-value pair to the cache
    public void put(int key, int value) {
        if (capacity == 0) {
            return; // If capacity is 0, do nothing
        }

        if (cache.containsKey(key)) { // If the key already exists
            DLLNode curNode = cache.get(key); // Get the existing node
            curNode.value = value; // Update the value
            updateNode(curNode); // Update the frequency of the node
        } else { // If the key does not exist
            curSize++; // Increment the current size
            if (curSize > capacity) { // If the cache exceeds capacity
                DoubleLinkedList minfreqList = frequencyMap.get(minfrequency); // Get the list for the minimum frequency
                cache.remove(minfreqList.tail.prev.key); // Remove the least frequently used key from the cache
                minfreqList.removeNode(minfreqList.tail.prev); // Remove the node from the frequency list
                curSize--; // Decrement the current size
            }
            minfrequency = 1; // Reset minimum frequency to 1
            DLLNode newNode = new DLLNode(key, value); // Create a new node

            // Get or create the list for frequency 1 and add the new node
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode); // Add the new node to the frequency list
            frequencyMap.put(1, curList); // Update the frequency map
            cache.put(key, newNode); // Add the new node to the cache
        }
    }

    // Method to update the frequency of a node
    public void updateNode(DLLNode curNode) {
        int curfreq = curNode.frequency; // Get the current frequency of the node
        DoubleLinkedList curList = frequencyMap.get(curfreq); // Get the list for the current frequency
        curList.removeNode(curNode); // Remove the node from the current frequency list

        // If the current frequency is the minimum and the list is empty, increment the minimum frequency
        if (curfreq == minfrequency && curList.listsize == 0) {
            minfrequency++;
        }
        curNode.frequency++; // Increment the frequency of the node

        // Get or create the list for the new frequency and add the node
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode); // Add the node to the new frequency list
        frequencyMap.put(curNode.frequency, newList); // Update the frequency map
    }

    // Class representing a node in the doubly linked list
    class DLLNode {
        int key; // Key of the node
        int value; // Value of the node
        int frequency; // Frequency of access
        DLLNode next; // Pointer to the next node
        DLLNode prev; // Pointer to the previous node
        
        // Constructor to initialize the node
        public DLLNode(int key, int value) {
            this.key = key; // Set the key
            this.value = value; // Set the value
            this.frequency = 1; // Initialize frequency to 1
        }
    }

    // Class representing a doubly linked list
    class DoubleLinkedList {
        int listsize; // Size of the list
        DLLNode head; // Head of the list
        DLLNode tail; // Tail of the list

        // Constructor to initialize the doubly linked list
        public DoubleLinkedList() {
            this.listsize = 0; // Initialize size to 0
            this.head = new DLLNode(0, 0); // Create a dummy head node
            this.tail = new DLLNode(0, 0); // Create a dummy tail node
            head.next = tail; // Link head to tail
            tail.prev = head; // Link tail to head
        }

        // Method to add a node to the list
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next; // Get the next node after head
            curNode.next = nextNode; // Link the new node to the next node
            curNode.prev = head; // Link the new node to the head
            head.next = curNode; // Link head to the new node
            nextNode.prev = curNode; // Link the next node back to the new node
            listsize++; // Increment the size of the list
        }

        // Method to remove a node from the list
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev; // Get the previous node
            DLLNode nextNode = curNode.next; // Get the next node
            prevNode.next = nextNode; // Link the previous node to the next node
            nextNode.prev = prevNode; // Link the next node back to the previous node
            listsize--; // Decrement the size of the list
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
