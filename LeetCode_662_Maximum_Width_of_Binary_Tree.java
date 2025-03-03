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
    public int widthOfBinaryTree(TreeNode root) {
        // If the root is null, the width of the tree is 0
        if (root == null) {
            return 0;
        }

        // Variable to store the maximum width of the binary tree
        int result = 0;

        // Queue to perform level order traversal, storing pairs of nodes and their corresponding indices
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        // Start with the root node at index 0
        q.add(new Pair<>(root, 0));

        // Perform level order traversal
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();
            // Get the minimum index at the current level to avoid overflow
            int mmin = q.peek().getValue();

            // Variables to track the first and last indices at the current level
            int first = 0, last = 0;

            // Iterate through all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Get the current node's index, adjusted by the minimum index
                int curr_id = q.peek().getValue() - mmin;
                // Get the current node from the queue
                TreeNode node = q.poll().getKey();

                // If it's the first node at this level, record its index
                if (i == 0) {
                    first = curr_id;
                }

                // If it's the last node at this level, record its index
                if (i == size - 1) {
                    last = curr_id;
                }

                // If the left child exists, add it to the queue with its index
                if (node.left != null) {
                    q.add(new Pair<>(node.left, curr_id * 2 + 1));
                }
                // If the right child exists, add it to the queue with its index
                if (node.right != null) {
                    q.add(new Pair<>(node.right, curr_id * 2 + 2));
                }
            }
            // Update the maximum width found so far
            result = Math.max(result, last - first + 1);
        }

        // Return the maximum width of the binary tree
        return result;
    }
}
