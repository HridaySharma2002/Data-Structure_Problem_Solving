class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length; // Get the number of nodes in the graph
        int dist1[] = new int[n]; // Array to store distances from node1
        int dist2[] = new int[n]; // Array to store distances from node2
        
        // Initialize distances to a large value (infinity)
        for (int i = 0; i < n; i++) {
            dist1[i] = dist2[i] = Integer.MAX_VALUE;
        }

        // Calculate distances from node1 and node2
        calculatedistance(edges, node1, dist1);
        calculatedistance(edges, node2, dist2);

        int minMaxDistance = Integer.MAX_VALUE; // To track the minimum of the maximum distances
        int resultNode = -1; // To store the result node index

        // Iterate through all nodes to find the optimal meeting node
        for (int i = 0; i < n; i++) {
            int maxDistance = Math.max(dist1[i], dist2[i]); // Get the maximum distance to the current node
            // Check if this is the smallest maximum distance found
            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance; // Update the minimum maximum distance
                resultNode = i; // Update the result node
            } else if (maxDistance == minMaxDistance && resultNode > i) {
                resultNode = i; // Choose the smaller index if distances are equal
            }
        }

        // Return the result node or -1 if no valid node was found
        return resultNode == Integer.MAX_VALUE ? -1 : resultNode;
    }

    // Helper method to calculate distances from a starting node
    private void calculatedistance(int[] edges, int startnode, int[] distances) {
        int currentnode = startnode; // Start from the given node
        int distance = 0; // Initialize distance counter
        // Traverse the graph until there are no more outgoing edges or we revisit a node
        while (currentnode != -1 && distances[currentnode] == Integer.MAX_VALUE) {
            distances[currentnode] = distance++; // Update the distance for the current node
            currentnode = edges[currentnode]; // Move to the next node
        }
    }
}
