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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val); // Create a new node if the tree is empty
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) {
                    cur = cur.right; // Move to the right subtree
                } else {
                    cur.right = new TreeNode(val); // Insert new node
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left; // Move to the left subtree
                } else {
                    cur.left = new TreeNode(val); // Insert new node
                    break;
                }
            }
        }
        return root; // Return the root of the tree
    }
}
