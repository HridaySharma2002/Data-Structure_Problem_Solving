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
    // Pointers to keep track of the nodes that need to be swapped
    TreeNode first; // The first node that is out of order
    TreeNode mid;   // The middle node that is out of order (in case of two nodes being swapped)
    TreeNode last;  // The last node that is out of order
    TreeNode prev;  // The previous node in the in-order traversal

    // In-order traversal to identify the nodes that are out of order
    public void inorder(TreeNode root) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }
        
        // Traverse the left subtree
        inorder(root.left);

        // Check if the current node is less than the previous node
        // This indicates a violation of the BST property
        if (prev != null && root.val < prev.val) {
            // If this is the first violation, mark the first and middle nodes
            if (first == null) {
                first = prev; // First node that is out of order
                mid = root;   // Current node is the middle node
            } else {
                // If this is the second violation, mark the last node
                last = root;  // Current node is the last node
            }
        }
        // Update the previous node to the current node
        prev = root;

        // Traverse the right subtree
        inorder(root.right);
    }

    // Method to recover the BST by swapping the identified nodes
    public void recoverTree(TreeNode root) {
        // Initialize pointers to null
        first = last = mid = null;
        // Initialize prev to a very small value to handle the first comparison
        prev = new TreeNode(Integer.MIN_VALUE);
        
        // Perform in-order traversal to find the nodes that need to be swapped
        inorder(root);

        // If two nodes were found that need to be swapped
        if (first != null && last != null) {
            // Swap the values of the first and last nodes
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // If only two nodes were found that are out of order (first and mid)
        else if (first != null && mid != null) {
            // Swap the values of the first and middle nodes
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
}
