/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // Stack to hold the nodes for in-order traversal
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    // Constructor that initializes the iterator with the root of the BST
    public BSTIterator(TreeNode root) {
        // Push all the leftmost nodes from the root onto the stack
        pushall(root);
    }
    
    // Method to return the next smallest value in the BST
    public int next() {
        // Pop the top node from the stack, which is the next smallest node
        TreeNode temp = stack.pop();
        // Push all the leftmost nodes of the right child of the popped node onto the stack
        pushall(temp.right);
        // Return the value of the popped node
        return temp.val;
    }
    
    // Method to check if there are more nodes to visit in the BST
    public boolean hasNext() {
        // Return true if the stack is not empty, indicating more nodes are available
        return !stack.isEmpty();
    }

    // Helper method to push all leftmost nodes starting from the given node onto the stack
    public void pushall(TreeNode node) {
        // Traverse the leftmost path of the tree and push each node onto the stack
        for (; node != null; stack.push(node), node = node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
