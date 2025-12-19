class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> result = new ArrayList<>(); // To store the final list of people who know the secret
        boolean vis[] = new boolean[n]; // vis[i] is true if person i knows the secret
        vis[0] = vis[firstPerson] = true; // Person 0 and firstPerson initially know the secret

        // Sort meetings by time in ascending order
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        int ind = 0; // Index to iterate through meetings
        while (ind < meetings.length) {
            int time = meetings[ind][2]; // Current time slot for meetings
            HashMap<Integer, List<Integer>> adj = new HashMap<>(); // Adjacency list for people meeting at this time
            HashSet<Integer> secret = new HashSet<>(); // People who already know the secret at this time

            // Group all meetings happening at the same time
            while (ind < meetings.length && meetings[ind][2] == time) {
                int x = meetings[ind][0];
                int y = meetings[ind][1];

                // Build the adjacency list for this time slot
                adj.computeIfAbsent(x, k -> new ArrayList<>());
                adj.computeIfAbsent(y, k -> new ArrayList<>());
                adj.get(x).add(y);
                adj.get(y).add(x);

                // If either person knows the secret, add them to the set
                if (vis[x]) {
                    secret.add(x);
                }
                if (vis[y]) {
                    secret.add(y);
                }
                ind++;
            }

            // Spread the secret among all connected people at this time
            for (int s : secret) {
                dfs(s, vis, adj);
            }
        }

        // Collect all people who know the secret
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                result.add(i);
            }
        }
        return result;
    }

    // Depth-First Search to propagate the secret among connected people
    private void dfs(int person, boolean[] vis, HashMap<Integer, List<Integer>> adj) {
        vis[person] = true; // Mark this person as knowing the secret
        List<Integer> neighbour = adj.get(person); // Get all people this person meets at this time
        for (int i = 0; i < neighbour.size(); i++) {
            if (!vis[neighbour.get(i)]) {
                dfs(neighbour.get(i), vis, adj); // Recursively spread the secret
            }
        }
    }
}
