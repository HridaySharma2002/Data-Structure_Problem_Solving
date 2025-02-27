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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // List to store the result
        right_side_view(root, result, 0); // Start the recursive helper method
        return result; // Return the final result
    }

    /**
     * This helper method performs a depth-first traversal of the binary tree
     * to populate the result list with the rightmost node values at each level.
     * 
     * @param root The current node being processed
     * @param result The list to store the right side view values
     * @param level The current level in the tree (depth)
     */
    public void right_side_view(TreeNode root, List<Integer> result, int level) {
        if (root == null) { // Base case: if the node is null, return
            return;
        }
        
        // If the current level is equal to the size of the result list,
        // it means we are visiting the first node at this level from the right side.
        if (level == result.size()) {
            result.add(root.val); // Add the node's value to the result
        }

        // First, traverse the right subtree (to ensure rightmost nodes are processed first)
        right_side_view(root.right, result, level + 1);
        // Then, traverse the left subtree
        right_side_view(root.left, result, level + 1);
    }
}
