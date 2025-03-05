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
    public int countNodes(TreeNode root) {
        // Base case: if the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int left = left_height(root);
        int right = right_height(root);

        // If the left and right heights are equal, the tree is a full binary tree
        if (left == right) {
            // The number of nodes in a full binary tree is (2^height - 1)
            return (1 << left) - 1; // Using bitwise shift for efficiency
        }

        // If the tree is not full, recursively count nodes in left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Calculates the height of the left subtree.
     * 
     * @param root The root node of the subtree.
     * @return The height of the left subtree.
     */
    public int left_height(TreeNode root) {
        int height = 0; // Initialize height counter
        // Traverse down the left side of the tree
        while (root != null) {
            height++; // Increment height for each level
            root = root.left; // Move to the left child
        }
        return height; // Return the total height of the left subtree
    }

    /**
     * Calculates the height of the right subtree.
     * 
     * @param root The root node of the subtree.
     * @return The height of the right subtree.
     */
    public int right_height(TreeNode root) {
        int height = 0; // Initialize height counter
        // Traverse down the right side of the tree
        while (root != null) {
            height++; // Increment height for each level
            root = root.right; // Move to the right child
        }
        return height; // Return the total height of the right subtree
    }
}
