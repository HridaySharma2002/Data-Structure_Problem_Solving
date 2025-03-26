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
        public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base case: if the current node is null, return null
        if (root == null) {
            return null;
        }

        // If the current node's value is less than the lower bound (low),
        // we discard the left subtree and recursively trim the right subtree
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If the current node's value is greater than the upper bound (high),
        // we discard the right subtree and recursively trim the left subtree
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // If the current node's value is within the range [low, high],
        // we recursively trim both the left and right subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // Return the current node as it is within the range
        return root;
    }
}
