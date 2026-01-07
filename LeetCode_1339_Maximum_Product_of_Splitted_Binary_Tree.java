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
    // The modulo value as required by the problem to prevent integer overflow
    private int MOD = (int)1e9 + 7;
    // Variable to store the total sum of all nodes in the tree
    long total = 0;
    // Variable to keep track of the maximum product found so far
    long result = Long.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        // Reset result for each call
        result = Long.MIN_VALUE;

        // First DFS to calculate the total sum of all nodes in the tree
        total = dfs(root);

        // Second DFS to compute the maximum product by considering each possible split
        dfs(root);

        // Return the result modulo MOD as required
        return (int)(result % MOD);
    }
    private long dfs(TreeNode root) {
        // Base case: if the node is null, its sum is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the sum of the left and right subtrees
        long sum = root.val + dfs(root.left) + dfs(root.right);

        // Update the result with the maximum product of the current split
        // (total - sum) is the sum of the other part after splitting
        result = Math.max(result, (total - sum) * sum);

        // Return the sum of the current subtree
        return sum;
    }
}
