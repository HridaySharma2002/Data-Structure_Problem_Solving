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
     * Calculates the maximum path sum in a binary tree.
     * The path can start and end at any node in the tree.
     *
     * @param root The root node of the binary tree
     * @return The maximum path sum in the binary tree
     */
    public int maxPathSum(TreeNode root) {
        // Array to hold the maximum path sum as a single element
        int maxi[] = new int[1];
        // Initialize the maximum path sum to the smallest possible integer value
        maxi[0] = Integer.MIN_VALUE;
        // Calculate the height of the tree and update the maximum path sum
        height(root, maxi);
        // Return the calculated maximum path sum
        return maxi[0];
    }

    /**
     * Calculates the height of the binary tree and updates the maximum path sum.
     * The height of a node is defined as the maximum sum of values from that node to any leaf.
     *
     * @param root The root node of the binary tree
     * @param maxi An array to hold the maximum path sum
     * @return The height of the tree rooted at the current node
     */
    public int height(TreeNode root, int maxi[]) {
        // Base case: if the current node is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree, ensuring non-negative heights
        int left_height = Math.max(0, height(root.left, maxi));
        // Recursively calculate the height of the right subtree, ensuring non-negative heights
        int right_height = Math.max(0, height(root.right, maxi));

        // Update the maximum path sum if the current path (left + right + root value) is greater
        maxi[0] = Math.max(maxi[0], left_height + right_height + root.val);

        // Return the height of the tree rooted at the current node
        // This is the maximum sum of values from the current node to any leaf
        return root.val + Math.max(left_height, right_height);
    }
}
