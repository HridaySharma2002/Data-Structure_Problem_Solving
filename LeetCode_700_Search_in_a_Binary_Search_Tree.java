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
    // Function to search for a value in a Binary Search Tree (BST)
    public TreeNode searchBST(TreeNode root, int val) {
        // Continue searching while the current node is not null and the value does not match
        while (root != null && root.val != val) {
            // If the value to search is less than the current node's value,
            // move to the left child; otherwise, move to the right child
            root = val < root.val ? root.left : root.right;
        }
        // Return the node if found, or null if the value is not present in the BST
        return root;
    }
}
