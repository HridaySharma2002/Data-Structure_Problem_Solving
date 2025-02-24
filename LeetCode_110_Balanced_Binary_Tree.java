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
     * Determines if a binary tree is height-balanced.
     * A binary tree is considered height-balanced if the depth of the two subtrees of every node
     * never differ by more than 1.
     *
     * @param root The root node of the binary tree
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced(TreeNode root) {
        // Call the height function and check if it returns -1 (indicating an unbalanced tree)
        return height(root) != -1;
    }

    /**
     * Calculates the height of the binary tree.
     * If the tree is unbalanced at any point, it returns -1.
     *
     * @param root The root node of the binary tree
     * @return The height of the tree if balanced, -1 if unbalanced
     */
    public int height(TreeNode root) {
        // Base case: if the current node is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int left_height = height(root.left);
        // If the left subtree is unbalanced, propagate -1 up
        if (left_height == -1) {
            return -1;
        }

        // Recursively calculate the height of the right subtree
        int right_height = height(root.right);
        // If the right subtree is unbalanced, propagate -1 up
        if (right_height == -1) {
            return -1;
        }

        // Check if the current node is balanced
        if (Math.abs(left_height - right_height) > 1) {
            return -1; // Unbalanced
        }

        // Return the height of the tree rooted at the current node
        return 1 + Math.max(left_height, right_height);
    }
}
