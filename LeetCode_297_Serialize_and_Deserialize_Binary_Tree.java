/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // If the root is null, return an empty string
        if (root == null) {
            return "";
        }

        // Initialize a queue for level-order traversal and a StringBuilder for the result
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root); // Start with the root node

        // Perform level-order traversal
        while (!q.isEmpty()) {
            TreeNode node = q.poll(); // Get the next node from the queue
            if (node == null) {
                res.append("n "); // Append "n" for null nodes
                continue; // Continue to the next iteration
            }
            res.append(node.val).append(" "); // Append the node's value
            q.add(node.left); // Add left child to the queue
            q.add(node.right); // Add right child to the queue
        }

        return res.toString().trim(); // Return the serialized string, trimmed of trailing spaces
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // If the data is empty, return null
        if (data.isEmpty()) {
            return null;
        }

        // Split the serialized string into an array of values
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        // Create the root node from the first value
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root); // Add the root to the queue

        // Iterate through the values to reconstruct the tree
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll(); // Get the parent node from the queue

            // Process left child
            if (!values[i].equals("n")) { // If the value is not "n"
                TreeNode left = new TreeNode(Integer.parseInt(values[i])); // Create left child
                parent.left = left; // Attach left child to parent
                q.add(left); // Add left child to the queue
            }

            // Process right child
            if (++i < values.length && !values[i].equals("n")) { // Check bounds and value
                TreeNode right = new TreeNode(Integer.parseInt(values[i])); // Create right child
                parent.right = right; // Attach right child to parent
                q.add(right); // Add right child to the queue
            }
        }
        return root; // Return the reconstructed tree's root
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
