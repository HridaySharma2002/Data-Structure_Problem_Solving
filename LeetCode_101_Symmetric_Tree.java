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
    public boolean isSymmetric(TreeNode root) {
        // If the root is null, the tree is symmetric (an empty tree is symmetric)
        return root == null || check_Symmetrical(root.left, root.right);
    }

    /**
     * This helper method checks if two subtrees are symmetric.
     * 
     * @param left The root of the left subtree
     * @param right The root of the right subtree
     * @return true if the two subtrees are symmetric, false otherwise
     */
    public boolean check_Symmetrical(TreeNode left, TreeNode right) {
        // If both nodes are null, they are symmetric
        if (left == null || right == null) {
            return left == right; // true if both are null, false if one is null
        }
        
        // If the values of the nodes are not equal, the trees are not symmetric
        if (left.val != right.val) {
            return false;
        }

        // Recursively check the left subtree of the left node and the right subtree of the right node
        // and the right subtree of the left node and the left subtree of the right node
        return check_Symmetrical(left.left, right.right) && check_Symmetrical(left.right, right.left);
    }
}
