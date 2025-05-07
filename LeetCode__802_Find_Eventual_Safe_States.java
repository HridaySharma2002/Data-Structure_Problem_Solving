class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Create a reverse adjacency list to represent the graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }

        // Initialize indegree array to count incoming edges for each node
        int indegree[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int it : graph[i]) {
                // For each edge from node 'i' to 'it', add 'i' to the reverse graph
                adjRev.get(it).add(i);
                // Increment the indegree of node 'i'
                indegree[i]++;
            }
        }

        // Create a queue to process nodes with no incoming edges (indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i); // Add safe nodes to the queue
            }
        }

        // Process the nodes in the queue
        while (!queue.isEmpty()) {
            int node = queue.remove(); // Get the current safe node
            safeNodes.add(node); // Mark this node as safe
            for (int it : adjRev.get(node)) {
                // Decrease the indegree of the original node
                indegree[it]--;
                // If indegree becomes 0, it means this node is now safe
                if (indegree[it] == 0) {
                    queue.add(it); // Add it to the queue for processing
                }
            }
        }

        // Sort the safe nodes before returning (optional, based on requirements)
        safeNodes.sort(Integer::compareTo);
        return safeNodes; // Return the list of safe nodes
    }
}
