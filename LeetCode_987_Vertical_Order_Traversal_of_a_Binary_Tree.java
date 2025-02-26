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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store nodes based on their vertical and level information
        Map<Integer, Map<Integer, List<Integer>>> nodes = new TreeMap<>();
        
        // Queue for BFS traversal, each element is a pair containing the node
        // and its vertical (x) and level (y) information
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> todo = new LinkedList<>();

        // Start with the root node at vertical 0 and level 0
        todo.add(new Pair<>(root, new Pair<>(0, 0)));

        // BFS traversal to populate the nodes map
        while (!todo.isEmpty()) {
            // Retrieve the node and its vertical and level information from the queue
            Pair<TreeNode, Pair<Integer, Integer>> p = todo.poll();
            TreeNode temp = p.getKey();

            // Extract the vertical (x) and level (y) information
            int x = p.getValue().getKey(); // x -> vertical position
            int y = p.getValue().getValue(); // y -> level position

            // Insert the node value into the corresponding vertical and level in the map
            nodes.computeIfAbsent(x, k -> new TreeMap<>())
                 .computeIfAbsent(y, k -> new ArrayList<>())
                 .add(temp.val);

            // Process the left child, decrementing the vertical position
            if (temp.left != null) {
                todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }

            // Process the right child, incrementing the vertical position
            if (temp.right != null) {
                todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Prepare the final result list by combining values from the map
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : nodes.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> set : entry.getValue().values()) {
                // Sort the list to maintain the required order
                Collections.sort(set);
                // Add all values from the TreeSet to the column list
                col.addAll(set);
            }
            // Add the column list to the final result
            result.add(col);
        }

        return result; // Return the vertical order traversal result
    }
}
