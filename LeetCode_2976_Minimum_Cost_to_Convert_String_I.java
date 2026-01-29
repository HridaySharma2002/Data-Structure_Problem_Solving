class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Use Integer.MAX_VALUE as a representation of "infinity" for unreachable conversions
        long infinity = Integer.MAX_VALUE;
        
        // Create a 26x26 matrix to store the minimum cost to convert one character to another
        // dist[i][j] represents the minimum cost to convert character 'a' + i to 'a' + j
        long[][] dist = new long[26][26];
        
        // Initialize the distance matrix:
        // - Set all costs to infinity initially (meaning no direct conversion known)
        // - Set cost to convert a character to itself as 0
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], infinity);
            dist[i][i] = 0;
        }
        
        // Fill in the direct conversion costs from the given original -> changed arrays
        // If multiple costs exist for the same conversion, keep the minimum cost
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';  // index of original character
            int v = changed[i] - 'a';   // index of changed character
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }
        
        // Use Floyd-Warshall algorithm to find the minimum cost to convert any character to any other
        // This accounts for indirect conversions through intermediate characters
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    // Only update if both parts of the path are reachable (not infinity)
                    if (dist[i][k] < infinity && dist[k][j] < infinity) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Calculate the total minimum cost to convert the entire source string to the target string
        long totalcost = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';  // source character index
            int v = target.charAt(i) - 'a';  // target character index
            
            // If conversion is impossible (cost is infinity), return -1
            if (dist[u][v] >= infinity) {
                return -1;
            }
            
            // Accumulate the cost for converting this character
            totalcost += dist[u][v];
        }
        
        // Return the total minimum cost for the full string conversion
        return totalcost;
    }
}
