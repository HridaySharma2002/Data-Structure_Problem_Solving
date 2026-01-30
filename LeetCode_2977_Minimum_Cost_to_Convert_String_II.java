class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        long INF = Long.MAX_VALUE; // Define infinity as max long value for unreachable states
        
        Map<String, Integer> id = new HashMap<>(); // Map each substring to a unique integer ID
        Set<Integer> len = new HashSet<>();        // Store lengths of all substrings involved in transformations
        int size = 0;                             // Counter for unique substrings
        int m = original.length;                  // Number of transformations given
        int n = source.length();                  // Length of source and target strings
        
        // Initialize distance matrix for substring transformations with INF
        long[][] dist = new long[201][201];
        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }
        
        // Assign IDs to all substrings in original and changed arrays and record their lengths
        for (int i = 0; i < m; i++) {
            if (!id.containsKey(original[i])) {
                id.put(original[i], size++);
                len.add(original[i].length()); // Record length of this substring
            }
            if (!id.containsKey(changed[i])) {
                id.put(changed[i], size++);
            }
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            // Update the cost to transform original[i] to changed[i] with minimum cost if multiple edges exist
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        // Distance from a substring to itself is zero
        for (int i = 0; i < size; i++) {
            dist[i][i] = 0;
        }
        
        // Floyd-Warshall algorithm to find minimum cost to transform any substring to any other substring
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                if (dist[i][k] != INF) {
                    for (int j = 0; j < size; j++) {
                        if (dist[k][j] != INF) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        
        // dp[i] represents the minimum cost to convert the first i characters of source to target
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0; // Base case: cost to convert empty substring is zero
        
        // Iterate over each position in the source string
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) {
                continue; // Skip if this state is unreachable
            }
            
            // If characters at position i are already equal, no cost to move forward by one character
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            
            // Try all substring lengths that appear in transformations
            for (int l : len) {
                if (i + l > n) {
                    continue; // Skip if substring goes beyond string length
                }
                
                // Extract substring from source and corresponding substring from target
                String s = source.substring(i, i + l);
                String t = target.substring(i, i + l);
                
                // Check if both substrings have assigned IDs (i.e., are known substrings)
                if (id.containsKey(s) && id.containsKey(t)) {
                    long d = dist[id.get(s)][id.get(t)]; // Minimum cost to transform s to t
                    if (d != INF) {
                        // Update dp for position i+l with the minimum cost found
                        dp[i + l] = Math.min(dp[i + l], dp[i] + d);
                    }
                }
            }
        }
        
        // If dp[n] is still INF, it means target cannot be formed; otherwise return minimum cost
        return dp[n] == INF ? -1 : dp[n];
    }
}
