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
    public int findBottomLeftValue(TreeNode root) {
        // Handle edge case where the root is null
        if (root == null) {
            return 0; // Return 0 or handle as needed
        }

        // Initialize a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node
        int leftmostValue = root.val; // Initialize leftmost value with root's value

        // Perform level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size(); // Get the number of nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Remove the front node from the queue
                // If this is the first node in the current level, update leftmost value
                if (i == 0) {
                    leftmostValue = node.val;
                }
                // Add left child to the queue if it exists
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // Add right child to the queue if it exists
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        // Return the leftmost value found in the last row of the tree
        return leftmostValue;
    }
}
