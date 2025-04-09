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
    // Main method to find the subtree containing all deepest leaves
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Start DFS and return the node that is the LCA of the deepest leaves
        return (TreeNode) dfs(root)[0];
    }

    // DFS function to find the deepest leaves and their LCA
    private Object[] dfs(TreeNode node) {
        // Base case: if the current node is null, return null and depth 0
        if (node == null) {
            return new Object[]{null, 0};
        }

        // Recursively find the deepest leaves in the left and right subtrees
        Object[] left = dfs(node.left);  // Result from the left subtree
        Object[] right = dfs(node.right); // Result from the right subtree

        // If both left and right depths are equal, the current node is the LCA
        if ((int) left[1] == (int) right[1]) {
            return new Object[]{node, (int) left[1] + 1}; // Return current node and increment depth
        }

        // If left depth is greater, return the left subtree's result
        if ((int) left[1] > (int) right[1]) {
            return new Object[]{left[0], (int) left[1] + 1}; // Return left node and increment depth
        } else {
            // If right depth is greater, return the right subtree's result
            return new Object[]{right[0], (int) right[1] + 1}; // Return right node and increment depth
        }
    }
}
