/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or matches either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for LCA in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Recursively search for LCA in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If left subtree returned null, LCA must be in the right subtree
        if (left == null) {
            return right;
        }
        // If right subtree returned null, LCA must be in the left subtree
        else if (right == null) {
            return left;
        }
        // If both left and right are non-null, the current root is the LCA
        else {
            return root;
        }
    }
}
