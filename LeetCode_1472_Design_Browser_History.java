// Class representing the browser history
class BrowserHistory {
    Node currentpage; // Pointer to the current page in the history

    // Constructor to initialize the browser history with the homepage
    public BrowserHistory(String homepage) {
        currentpage = new Node(homepage); // Create a new node for the homepage
    }
    
    // Method to visit a new URL
    public void visit(String url) {
        Node newNode = new Node(url); // Create a new node for the new URL
        newNode.prev = currentpage; // Set the previous pointer of the new node to the current page
        currentpage.next = newNode; // Link the current page to the new node
        currentpage = newNode; // Move the current page pointer to the new node
    }
    
    // Method to go back 'steps' in the history
    public String back(int steps) {
        // Move back 'steps' times, ensuring we don't go past the beginning
        while (steps-- != 0) {
            if (currentpage.prev != null) { // Check if there is a previous page
                currentpage = currentpage.prev; // Move to the previous page
            } else {
                break; // If no previous page, exit the loop
            }
        }
        return currentpage.data; // Return the URL of the current page
    }
    
    // Method to go forward 'steps' in the history
    public String forward(int steps) {
        // Move forward 'steps' times, ensuring we don't go past the end
        while (steps-- != 0) {
            if (currentpage.next != null) { // Check if there is a next page
                currentpage = currentpage.next; // Move to the next page
            } else {
                break; // If no next page, exit the loop
            }
        }
        return currentpage.data; // Return the URL of the current page
    }
}

// Class representing a node in the linked list
class Node {
    String data; // Data field to store the URL
    Node next; // Pointer to the next node in the history
    Node prev; // Pointer to the previous node in the history

    // Default constructor
    Node() {}

    // Constructor to initialize the node with a URL
    Node(String data) {
        this.data = data; // Set the URL data
        this.next = null; // Initialize next pointer to null
        this.prev = null; // Initialize previous pointer to null
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); // Create a new BrowserHistory object with the homepage
 * obj.visit(url); // Visit a new URL
 * String param_2 = obj.back(steps); // Go back 'steps' in history and get the current page URL
 * String param_3 = obj.forward(steps); // Go forward 'steps' in history and get the current page URL
 */
