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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Check for null inputs or mismatched lengths
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null; // Return null if inputs are invalid
        }

        // Create a map to store the index of each value in the inorder array for quick lookup
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // Populate the map with inorder values and their indices
        }

        // Call the recursive function to build the tree
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

        return root; // Return the constructed tree's root
    }

    /**
     * Recursive helper function to build the binary tree.
     * 
     * @param inorder The inorder traversal of the tree.
     * @param instart The starting index of the current subtree in inorder.
     * @param inend The ending index of the current subtree in inorder.
     * @param postorder The postorder traversal of the tree.
     * @param poststart The starting index of the current subtree in postorder.
     * @param postend The ending index of the current subtree in postorder.
     * @param map A map that stores the index of each value in the inorder array.
     * @return The root of the constructed subtree.
     */
    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, Map<Integer, Integer> map) {
        // Base case: if the current subtree is invalid
        if (instart > inend || poststart > postend) {
            return null; // Return null if there are no elements to construct the subtree
        }

        // The last element in the postorder array is the root of the current subtree
        TreeNode root = new TreeNode(postorder[postend]);

        // Find the index of the root in the inorder array
        int inroot = map.get(root.val);
        // Calculate the number of nodes in the left subtree
        int numsleft = inroot - instart;

        // Recursively build the left and right subtrees
        root.left = buildTree(inorder, instart, inroot - 1, postorder, poststart, poststart + numsleft - 1, map);
        root.right = buildTree(inorder, inroot + 1, inend, postorder, poststart + numsleft, postend - 1, map);

        return root; // Return the constructed subtree's root
    }
}
