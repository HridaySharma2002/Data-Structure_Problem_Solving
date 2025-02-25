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
    /**
     * Checks if two binary trees are the same.
     * Two binary trees are considered the same if they are structurally identical
     * and the nodes have the same value.
     *
     * @param p The root node of the first binary tree
     * @param q The root node of the second binary tree
     * @return true if the two trees are the same, false otherwise
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If either of the nodes is null, check if both are null
        if (p == null || q == null) {
            return (p == q); // Both must be null to be considered the same
        }

        // Check if the current nodes have the same value and recursively check their children
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
