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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // If the tree is empty, return null
        }
        if (root.val == key) {
            return helper(root); // If the root is the node to be deleted, use helper to delete it
        }

        TreeNode dummy = root; // Keep a reference to the original root
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left); // Delete the left child if it matches the key
                    break;
                } else {
                    root = root.left; // Move to the left subtree
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right); // Delete the right child if it matches the key
                    break;
                } else {
                    root = root.right; // Move to the right subtree
                }
            }
        }
        return dummy; // Return the original root of the tree
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right; // If there is no left child, return the right child
        } else if (root.right == null) {
            return root.left; // If there is no right child, return the left child
        } else {
            TreeNode rightChild = root.right; // Store the right child
            TreeNode lastRight = lastRightChild(root.left); // Find the last right child of the left subtree
            lastRight.right = rightChild; // Connect the last right child to the right subtree
            return root.left; // Return the left subtree
        }
    }

    public TreeNode lastRightChild(TreeNode root) {
        if (root.right == null) {
            return root; // Return the last right child
        }
        return lastRightChild(root.right); // Recursively find the last right child
    }
}
