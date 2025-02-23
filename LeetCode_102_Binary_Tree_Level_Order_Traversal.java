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
     * Performs level order traversal of a binary tree.
     * 
     * @param root The root node of the binary tree
     * @return A list of lists containing the values of nodes at each level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list to hold levels
        if (root == null) { // Check if the tree is empty
            return result; // Return an empty list if there are no nodes
        }

        Queue<TreeNode> q = new LinkedList<>(); // Create a queue to facilitate level order traversal
        q.add(root); // Start with the root node in the queue

        // Continue until there are no more nodes to process
        while (!q.isEmpty()) {
            int size = q.size(); // Get the number of nodes at the current level

            List<Integer> level = new ArrayList<>(); // Create a list to hold the current level's values
            for (int i = 0; i < size; i++) { // Iterate through all nodes at the current level
                TreeNode node = q.poll(); // Remove the front node from the queue
                level.add(node.val); // Add the node's value to the current level list

                // If the left child exists, add it to the queue for processing in the next level
                if (node.left != null) {
                    q.add(node.left);
                }

                // If the right child exists, add it to the queue for processing in the next level
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(level); // Add the current level's values to the result list
        }
        return result; // Return the complete list of levels
    }
}
