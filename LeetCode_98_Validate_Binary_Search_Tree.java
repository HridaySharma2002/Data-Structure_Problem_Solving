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
    public boolean isValidBST(TreeNode root) {
        // Call the helper method with initial min and max values
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long minval, long maxval) {
        // Base case: an empty tree is a valid BST
        if (root == null) {
            return true;
        }
        // Check if the current node's value is within the valid range
        if (root.val <= minval || root.val >= maxval) {
            return false; // Invalid if the current node's value is out of bounds
        }

        // Recursively check the left and right subtrees with updated bounds
        return isValidBST(root.left, minval, root.val) && isValidBST(root.right, root.val, maxval);
    }
}
