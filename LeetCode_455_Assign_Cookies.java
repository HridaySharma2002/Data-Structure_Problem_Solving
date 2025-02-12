class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Initialize pointers for the children (r) and the cookies (l)
        int r = 0; // Pointer for children
        int l = 0; // Pointer for cookies
        
        // Sort the arrays to facilitate the greedy approach
        Arrays.sort(g); // Sort children's greed factors
        Arrays.sort(s); // Sort cookie sizes
        
        // Iterate through both arrays to find the maximum number of content children
        while (l < s.length && r < g.length) {
            // If the current cookie can satisfy the current child's greed
            if (g[r] <= s[l]) {
                r++; // Move to the next child
            }
            l++; // Move to the next cookie
        }
        
        // Return the number of content children
        return r; // r represents the number of satisfied children
    }
}
