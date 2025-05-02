class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a graph using an adjacency list representation
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // Initialize each course's list
        }

        // Populate the graph with edges based on prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            // prerequisites[i][1] must be taken before prerequisites[i][0]
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Create an indegree array to count prerequisites for each course
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : graph.get(i)) {
                indegree[node]++; // Increment indegree for each dependent course
            }
        }

        // Initialize a queue to hold courses with no prerequisites (indegree 0)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i); // Add courses with no prerequisites to the queue
            }
        }

        // Prepare an array to store the topological order of courses
        int ts[] = new int[numCourses];
        int i = 0; // Index for the topological order array

        // Process the queue until it's empty
        while (!q.isEmpty()) {
            int node = q.remove(); // Get the course with no prerequisites
            ts[i++] = node; // Add it to the topological order

            // Decrease the indegree of neighboring courses
            for (int nbr : graph.get(node)) {
                indegree[nbr]--; // One less prerequisite for the neighbor
                if (indegree[nbr] == 0) {
                    q.add(nbr); // If no more prerequisites, add to queue
                }
            }
        }

        // Check if all courses were processed
        if (i == 0 || i < numCourses) {
            return new int[]{}; // Return empty array if not all courses can be completed
        }

        // Return the topological order of courses
        return ts; // Valid order of courses to take
    }
}
