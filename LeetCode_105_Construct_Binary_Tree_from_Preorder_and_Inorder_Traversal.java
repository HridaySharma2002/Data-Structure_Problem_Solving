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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the index of each value in the inorder array for quick lookup
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        // Call the recursive function to build the tree
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inmap);

        return root;
    }

    /**
     * Recursive helper function to build the binary tree.
     * 
     * @param preorder The preorder traversal of the tree.
     * @param prestart The starting index of the current subtree in preorder.
     * @param preend The ending index of the current subtree in preorder.
     * @param inorder The inorder traversal of the tree.
     * @param instart The starting index of the current subtree in inorder.
     * @param inend The ending index of the current subtree in inorder.
     * @param inmap A map that stores the index of each value in the inorder array.
     * @return The root of the constructed subtree.
     */
    public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> inmap) {
        // Base case: if the current subtree is invalid
        if (prestart > preend || instart > inend) {
            return null;
        }

        // The first element in the preorder array is the root of the current subtree
        TreeNode root = new TreeNode(preorder[prestart]);

        // Find the index of the root in the inorder array
        int inroot = inmap.get(root.val);
        // Calculate the number of nodes in the left subtree
        int numsleft = inroot - instart;

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, prestart + 1, prestart + numsleft, inorder, instart, inroot - 1, inmap);
        root.right = buildTree(preorder, prestart + numsleft + 1, preend, inorder, inroot + 1, inend, inmap);

        return root;
    }
}
