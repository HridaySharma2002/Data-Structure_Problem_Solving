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
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map to store parent pointers for each node
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        // Populate the parent map by traversing the tree
        markParents(root, null, parent);

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Set to keep track of visited nodes to avoid revisiting
        Set<TreeNode> visited = new HashSet<>();

        // Find the target node in the tree
        TreeNode tgt = findNode(target.val, root);
        if (tgt == null) {
            // If the target node is not found, return an empty list
            return new ArrayList<>();
        }

        // Start BFS from the target node
        queue.offer(tgt);
        visited.add(tgt);

        int level = 0; // Tracks the current level in BFS
        while (!queue.isEmpty()) {
            if (level == k) {
                // Stop BFS when the desired level is reached
                break;
            }
            int size = queue.size(); // Number of nodes at the current level
            level++;

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add the left child to the queue if it exists and hasn't been visited
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                // Add the right child to the queue if it exists and hasn't been visited
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // Add the parent node to the queue if it exists and hasn't been visited
                TreeNode parentNode = parent.get(current);
                if (parentNode != null && !visited.contains(parentNode)) {
                    queue.offer(parentNode);
                    visited.add(parentNode);
                }
            }
        }

        // Collect all nodes at the desired level (distance `k`)
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        // Sort the result to ensure the output is in ascending order
        Collections.sort(result);

        return result;
    }

    /**
     * Marks the parent of each node in the binary tree.
     * 
     * @param root The current node being processed.
     * @param par The parent of the current node.
     * @param parent A map to store the parent pointers for each node.
     */
    public void markParents(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return; // Base case: if the node is null, return
        }
        parent.put(root, par); // Map the current node to its parent
        markParents(root.left, root, parent); // Recur for the left subtree
        markParents(root.right, root, parent); // Recur for the right subtree
    }

    /**
     * Finds a node with the given value in the binary tree.
     * 
     * @param val The value of the node to find.
     * @param root The root of the binary tree.
     * @return The TreeNode with the given value, or null if not found.
     */
    public TreeNode findNode(int val, TreeNode root) {
        if (root == null) {
            return null; // Base case: if the node is null, return null
        }

        if (root.val == val) {
            return root; // If the current node matches the value, return it
        }

        // Recur for the left and right subtrees
        TreeNode left = findNode(val, root.left);
        TreeNode right = findNode(val, root.right);

        // Return the node if found in either subtree
        return left != null ? left : right;
    }
}
