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
    // Main method to construct the BST from the given preorder traversal array
    public TreeNode bstFromPreorder(int[] preorder) {
        // Start the recursive construction with the maximum possible value as the bound
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    // Recursive helper method to construct the BST
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        // Base case: if the index is out of bounds or the current value exceeds the bound
        if (i[0] == preorder.length || preorder[i[0]] > bound) {
            return null; // Return null if we cannot create a valid node
        }

        // Create a new TreeNode with the current value from the preorder array
        TreeNode root = new TreeNode(preorder[i[0]++]);
        
        // Recursively construct the left subtree with the current node's value as the new bound
        root.left = bstFromPreorder(preorder, root.val, i);
        
        // Recursively construct the right subtree with the original bound
        root.right = bstFromPreorder(preorder, bound, i);
        
        // Return the constructed node
        return root;
    }
}
