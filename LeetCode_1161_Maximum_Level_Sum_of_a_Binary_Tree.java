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
    public int maxLevelSum(TreeNode root) {
        long maxsum = Long.MIN_VALUE;  // Stores the maximum sum found so far
        int level = 1;                 // Current level being processed
        int resultlevel = 1;           // Level with the maximum sum
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);               // Start BFS from the root
        
        while (!queue.isEmpty()) {
            long levelsum = 0;         // Sum of values at the current level
            int size = queue.size();   // Number of nodes at the current level
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelsum += node.val;  // Add current node's value to level sum
                
                // Add left child to queue if it exists
                if (node.left != null) {
                    queue.add(node.left);
                }
                // Add right child to queue if it exists
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            // Update maxsum and resultlevel if current level sum is greater
            if (levelsum > maxsum) {
                maxsum = levelsum;
                resultlevel = level;
            }
            level++;  // Move to the next level
        }
        
        return resultlevel;
    }
}
