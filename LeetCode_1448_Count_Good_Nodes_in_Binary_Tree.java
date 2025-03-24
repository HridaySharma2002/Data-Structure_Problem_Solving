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
        public int goodNodes(TreeNode root) {
        // Start the depth-first search (DFS) with the root node and its value as the initial maximum
        return dfs(root, root.val);
    }

    /**
     * This helper method performs a depth-first search to count good nodes.
     *
     * @param node The current node being processed
     * @param maxValue The maximum value encountered along the path from the root to the current node
     * @return The count of good nodes in the subtree rooted at the current node
     */
    private int dfs(TreeNode node, int maxValue) {
        // Base case: if the current node is null, return 0
        if (node == null) {
            return 0;
        }

        // Count this node as good if its value is greater than or equal to maxValue
        int count = (node.val >= maxValue) ? 1 : 0;

        // Update the maximum value for the path
        maxValue = Math.max(maxValue, node.val);

        // Recursively count good nodes in the left and right subtrees
        count += dfs(node.left, maxValue);
        count += dfs(node.right, maxValue);

        // Return the total count of good nodes found
        return count;
    }
}
