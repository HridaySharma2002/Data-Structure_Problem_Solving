class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length; // Get the number of vertices in the graph
        int color[] = new int[V]; // Array to store colors of vertices
        
        // Initialize all vertices as uncolored
        for (int i = 0; i < V; i++) {
            color[i] = -1; // -1 indicates that the vertex is uncolored
        }

        // Check each vertex to ensure all components are processed
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // If the vertex is uncolored
                // Call the check method to see if the component is bipartite
                if (!check(i, graph, color)) {
                    return false; // If not bipartite, return false
                }
            }
        }

        return true; // If all components are bipartite, return true
    }

    public boolean check(int start, int[][] graph, int[] color) {
        color[start] = 0; // Color the starting vertex with color 0
        Queue<Integer> queue = new LinkedList<>(); // Initialize a queue for BFS
        queue.add(start); // Add the starting vertex to the queue

        // Perform BFS to color the graph
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Get the front node from the queue
            // Iterate through all adjacent vertices
            for (int it : graph[node]) {
                if (color[it] == -1) { // If the adjacent vertex is uncolored
                    color[it] = 1 - color[node]; // Assign the opposite color
                    queue.add(it); // Add the adjacent vertex to the queue
                } else if (color[it] == color[node]) { // If the adjacent vertex has the same color
                    return false; // Not bipartite
                }
            }
        }
        return true; // All adjacent vertices can be colored properly
    }

// //Using dfs
//     public boolean dfs_check(int node,int col,int graph[][],int color[]){
//         color[node]=col;
//         for(int it:graph[node]){
//             if(color[it]==-1){
//                 if(!dfs(it,1-col,graph,color)){
//                     return false;
//                 }
//             }
//             else if(color[it]==color[node]){
//                 return false;
//             }
//         }
//         return true;
//     }
}
