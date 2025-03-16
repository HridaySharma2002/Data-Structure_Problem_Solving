/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }

        TreeNode cur = root; // Start with the current node as the root

        // If both p and q are greater than the current node, LCA must be in the right subtree
        if (cur.val < p.val && cur.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are less than the current node, LCA must be in the left subtree
        if (cur.val > p.val && cur.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If we reach here, it means we have found the split point,
        // i.e., one node is on the left and the other is on the right,
        // or one of them is the current node. Thus, the current node is the LCA.
        return root;
    }
}
