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
class Solution {
    // Method to determine if there exist two elements in the BST such that their sum equals k
    public boolean findTarget(TreeNode root, int k) {
        // If the root is null, there is no tree to search, so return false
        if (root == null) {
            return false;
        }

        // Create two BST iterators:
        // 'l' for normal in-order traversal (smallest to largest)
        // 'r' for reverse in-order traversal (largest to smallest)
        BSTIterator l = new BSTIterator(root, false); // Left-to-right traversal
        BSTIterator r = new BSTIterator(root, true);  // Right-to-left traversal

        // Get the first values from both iterators
        int i = l.next(); // Smallest value
        int j = r.next(); // Largest value

        // Use two-pointer technique to find if there exist two numbers that sum to k
        while (i < j) {
            // If the sum of the two numbers equals k, return true
            if (i + j == k) {
                return true;
            }
            // If the sum is less than k, move the left pointer to the next larger value
            else if (i + j < k) {
                i = l.next();
            }
            // If the sum is greater than k, move the right pointer to the next smaller value
            else {
                j = r.next();
            }
        }

        // If no such pair is found, return false
        return false;
    }
}

class BSTIterator {
    // Stack to store the nodes for traversal
    Stack<TreeNode> stack = new Stack<TreeNode>();
    // Boolean to determine the direction of traversal
    boolean reverse = true;

    // Constructor to initialize the iterator
    // 'isreverse' determines the traversal direction:
    // true for reverse in-order (right-to-left), false for normal in-order (left-to-right)
    public BSTIterator(TreeNode root, boolean isreverse) {
        reverse = isreverse;
        // Push all nodes along the initial path (leftmost or rightmost) onto the stack
        pushAll(root);
    }

    // Method to check if there are more nodes to traverse
    public boolean hashnext() {
        // Return true if the stack is not empty
        return !stack.isEmpty();
    }

    // Method to get the next value in the traversal
    public int next() {
        // Pop the top node from the stack
        TreeNode temp = stack.pop();
        // If reverse is true, push all left children of the current node onto the stack
        // Otherwise, push all right children of the current node onto the stack
        if (reverse == true) {
            pushAll(temp.left);
        } else {
            pushAll(temp.right);
        }
        // Return the value of the popped node
        return temp.val;
    }

    // Helper method to push all nodes along the leftmost or rightmost path onto the stack
    public void pushAll(TreeNode root) {
        // Traverse the tree and push nodes onto the stack
        while (root != null) {
            stack.push(root);
            // If reverse is true, move to the right child (reverse in-order)
            // Otherwise, move to the left child (normal in-order)
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}
