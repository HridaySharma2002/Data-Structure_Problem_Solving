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
    public int kthSmallest(TreeNode root, int k) {
        int[] k_smallest = new int[]{Integer.MIN_VALUE}; // Array to store the k-th smallest value
        int[] counter = new int[]{0}; // Counter to track the number of nodes processed
        inorder(root, counter, k, k_smallest); // Perform in-order traversal
        return k_smallest[0]; // Return the k-th smallest value
    }

    public void inorder(TreeNode root, int[] counter, int k, int[] k_smallest) {
        if (root == null || counter[0] >= k) {
            return; // Base case: if the node is null or we've found the k-th smallest
        }
        inorder(root.left, counter, k, k_smallest); // Traverse the left subtree
        counter[0]++; // Increment the counter after visiting a node
        if (counter[0] == k) {
            k_smallest[0] = root.val; // Store the k-th smallest value
            return; // Exit if we've found the k-th smallest
        }
        inorder(root.right, counter, k, k_smallest); // Traverse the right subtree
    }
}
