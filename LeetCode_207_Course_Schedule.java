class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with the prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            // prerequisites[i][0] is the course that depends on prerequisites[i][1]
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Initialize indegree array to count prerequisites for each course
        int indegree[] = new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        // Create a queue to process courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i); // Add courses with no prerequisites to the queue
            }
        }

        // List to store the topological order of courses
        List<Integer> topo = new ArrayList<>();
        
        // Process the courses in the queue
        while (!queue.isEmpty()) {
            int node = queue.remove(); // Get the course with no prerequisites
            topo.add(node); // Add it to the topological order

            // Decrease the indegree of adjacent courses
            for (int it : adj.get(node)) {
                indegree[it]--;
                // If indegree becomes zero, add it to the queue
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        
        // If the number of courses in the topological order equals numCourses, return true
        return topo.size() == numCourses;
    }
}
