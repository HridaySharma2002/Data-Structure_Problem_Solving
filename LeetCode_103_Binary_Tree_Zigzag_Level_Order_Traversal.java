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
     * Performs a zigzag level order traversal of a binary tree.
     * The traversal alternates between left-to-right and right-to-left for each level.
     *
     * @param root The root node of the binary tree
     * @return A list of lists containing the values of the nodes in zigzag order
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // List to hold the final zigzag order result
        if (root == null) {
            return result; // Return an empty list if the tree is empty
        }

        Queue<TreeNode> q = new LinkedList<>(); // Queue to facilitate level order traversal
        q.add(root); // Start with the root node

        boolean left_to_right = true; // Flag to track the direction of traversal

        // Continue until there are no more nodes to process
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at the current level
            List<Integer> row = new ArrayList<>(); // List to hold the values of the current level

            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // Remove the front node from the queue

                // Add the node value to the row based on the current direction
                if (left_to_right) {
                    row.add(node.val); // Add to the end of the list for left-to-right traversal
                } else {
                    row.add(0, node.val); // Add to the beginning of the list for right-to-left traversal
                }

                // Add the left and right children to the queue for the next level
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            left_to_right = !left_to_right; // Toggle the direction for the next level
            result.add(row); // Add the current level's values to the result
        }
        return result; // Return the final zigzag order result
    }
}
