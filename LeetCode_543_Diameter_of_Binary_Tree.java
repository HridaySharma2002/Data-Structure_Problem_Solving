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
     * Calculates the diameter of a binary tree.
     * The diameter is defined as the length of the longest path between any two nodes in the tree.
     * This path may or may not pass through the root.
     *
     * @param root The root node of the binary tree
     * @return The diameter of the binary tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Array to hold the diameter as a single element
        int diameter[] = new int[1];
        // Calculate the height of the tree and update the diameter
        height(root, diameter);

        // Return the calculated diameter
        return diameter[0];
    }

    /**
     * Calculates the height of the binary tree and updates the diameter.
     * The height of a node is defined as the number of edges in the longest path from that node to a leaf.
     *
     * @param root The root node of the binary tree
     * @param diameter An array to hold the diameter of the tree
     * @return The height of the tree rooted at the current node
     */
    public int height(TreeNode root, int diameter[]) {
        // Base case: if the current node is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int left_height = height(root.left, diameter);
        // Recursively calculate the height of the right subtree
        int right_height = height(root.right, diameter);

        // Update the diameter if the current path is longer than the previously recorded diameter
        diameter[0] = Math.max(diameter[0], left_height + right_height);

        // Return the height of the tree rooted at the current node
        return 1 + Math.max(left_height, right_height);
    }
}
