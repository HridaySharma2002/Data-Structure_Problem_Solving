class LRUCache {
    // HashMap to store key-node pairs for O(1) access
    Map<Integer, Node> map = new HashMap<>();
    
    // Dummy head and tail nodes for the doubly linked list
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    // Maximum capacity of the cache
    int capacity;

    // Constructor to initialize the LRUCache with a specified capacity
    public LRUCache(int capacity) {
        this.capacity = capacity; // Set the capacity
        head.next = tail; // Initialize the linked list
        tail.prev = head; // Link head and tail
    }
    
    // Method to retrieve a value by key
    public int get(int key) {
        // Check if the key exists in the map
        if (map.containsKey(key)) {
            Node node = map.get(key); // Get the node
            remove(node); // Remove the node from its current position
            insert(node); // Reinsert it to mark it as recently used
            return node.value; // Return the value
        } else {
            return -1; // Return -1 if the key is not found
        }
    }
    
    // Method to add a key-value pair to the cache
    public void put(int key, int value) {
        // If the key already exists, remove it
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        // If the cache is at capacity, remove the least recently used item
        if (map.size() == capacity) {
            remove(tail.prev); // Remove the node before the tail
        }
        // Insert the new node into the cache
        insert(new Node(key, value));
    }

    // Method to remove a node from the linked list and map
    public void remove(Node node) {
        map.remove(node.key); // Remove the node's key from the map
        // Bypass the node in the linked list
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
    }
    
    // Method to insert a node at the front of the linked list
    public void insert(Node node) {
        map.put(node.key, node); // Add the node to the map
        // Update pointers to insert the node at the front
        node.next = head.next; 
        node.next.prev = node; 
        head.next = node; 
        node.prev = head; 
    }

    // Inner class representing a node in the doubly linked list
    class Node {
        Node next, prev; // Pointers to the next and previous nodes
        int key, value; // Key-value pair

        // Constructor to create a new node
        Node(int key, int value) {
            this.key = key; // Set the key
            this.value = value; // Set the value
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
