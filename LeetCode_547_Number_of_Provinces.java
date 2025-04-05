class Solution {
    // This method finds the number of provinces (connected components) in the isConnected matrix
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length; // Get the number of cities (nodes)
        boolean vis[] = new boolean[V]; // Array to track visited cities
        int count = 0; // Counter for the number of provinces
        
        // Iterate through each city
        for (int i = 0; i < V; i++) {
            // If the city has not been visited, it indicates a new province
            if (!vis[i]) {
                count++; // Increment the province count
                dfs(i, isConnected, vis); // Perform DFS to mark all connected cities
            }
        }

        return count; // Return the total number of provinces
    }

    // DFS function to explore all cities connected to the current city
    public void dfs(int node, int[][] isConnected, boolean vis[]) {
        vis[node] = true; // Mark the current city as visited
        
        // Check all cities to find connections
        for (int i = 0; i < isConnected.length; i++) {
            // If there is a connection and the city has not been visited
            if (isConnected[node][i] == 1 && !vis[i]) {
                dfs(i, isConnected, vis); // Recursively visit the connected city
            }
        }
    }
}
