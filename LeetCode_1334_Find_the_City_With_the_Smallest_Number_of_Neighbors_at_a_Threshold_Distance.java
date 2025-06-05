class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix with maximum values
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE; // Set initial distances to infinity
            }
        }

        // Populate the distance matrix with the weights of the edges
        for (int edge[] : edges) {
            dist[edge[0]][edge[1]] = edge[2]; // Set distance for the edge from city A to city B
            dist[edge[1]][edge[0]] = edge[2]; // Set distance for the edge from city B to city A (bidirectional)
        }

        // Set the distance from each city to itself as 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Floyd-Warshall algorithm to find the shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Check for overflow in distance calculations
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue; // Skip if there's no path
                    }
                    // Update the distance if a shorter path is found
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n; // Initialize the count of reachable cities
        int cityNo = -1; // Variable to store the city number with the smallest neighbors

        // Iterate through each city to count reachable cities within the distance threshold
        for (int city = 0; city < n; city++) {
            int cnt = 0; // Count of reachable cities for the current city
            for (int adjcity = 0; adjcity < n; adjcity++) {
                if (dist[city][adjcity] <= distanceThreshold) {
                    cnt++; // Increment count if the city is reachable within the threshold
                }
            }
            // Update the city with the smallest number of reachable neighbors
            if (cnt <= cntCity) {
                cntCity = cnt; // Update the count of reachable cities
                cityNo = city; // Update the city number
            }
        }

        return cityNo; // Return the city with the smallest number of neighbors
    }
}
