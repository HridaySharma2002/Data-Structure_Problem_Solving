class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];  // dp[i][j] stores the minimum triangulation score for polygon vertices from i to j
        
        // Iterate over the vertices in reverse order to ensure smaller subproblems are solved before larger ones
        for (int i = n - 1; i >= 0; i--) {
            // j starts from i+1 because a polygon segment must have at least two vertices
            for (int j = i + 1; j < n; j++) {
                // k iterates over all possible points between i and j to form a triangle (i, k, j)
                for (int k = i + 1; k < j; k++) {
                    // Calculate the cost of triangulation by choosing k as the vertex to form a triangle with i and j
                    // dp[i][k] and dp[k][j] are the costs of triangulating the sub-polygons
                    // values[i] * values[j] * values[k] is the cost of the triangle formed by vertices i, j, k
                    // If dp[i][j] is 0 (not set yet), initialize it with Integer.MAX_VALUE for min comparison
                    dp[i][j] = Math.min(
                        dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                        dp[i][k] + values[i] * values[j] * values[k] + dp[k][j]
                    );
                }
            }
        }
        
        // The result is the minimum triangulation score for the entire polygon from vertex 0 to vertex n-1
        return dp[0][n - 1];
    }
}
