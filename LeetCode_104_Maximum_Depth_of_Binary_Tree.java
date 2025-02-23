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
    public int maxDepth(TreeNode root) {
        // Base case: if the current node is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left subtree
        int left_height = maxDepth(root.left);
        // Recursively calculate the depth of the right subtree
        int right_height = maxDepth(root.right);

        // The maximum depth is the greater of the two heights plus one for the current node
        return 1 + Math.max(left_height, right_height);
    }
}
