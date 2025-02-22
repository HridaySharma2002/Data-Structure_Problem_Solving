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
    // Method to perform inorder traversal of the binary tree
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // Initialize a list to store the traversal result
        inorder(root, result); // Call the helper method to fill the result list
        return result; // Return the result list
    }

    // Helper method to perform the actual inorder traversal
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) { // Base case: if the current node is null, return
            return;
        }
        inorder(root.left, result); // Recursively traverse the left subtree
        result.add(root.val); // Add the value of the current node to the result list
        inorder(root.right, result); // Recursively traverse the right subtree
    }
}
