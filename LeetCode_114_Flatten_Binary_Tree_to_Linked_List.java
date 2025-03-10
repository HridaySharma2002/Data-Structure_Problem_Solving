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
    public void flatten(TreeNode root) {
        // Start with the current node as the root
        TreeNode cur = root;

        // Iterate while there are nodes to process
        while (cur != null) {
            // If the current node has a left child
            if (cur.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right; // Move to the rightmost node
                }

                // Connect the right subtree of the current node to the rightmost node
                pre.right = cur.right;

                // Move the left subtree to the right
                cur.right = cur.left;

                // Set the left child to null as it is no longer needed
                cur.left = null;
            }
            // Move to the next node in the flattened tree (which is now the right child)
            cur = cur.right;
        }
    }
}
