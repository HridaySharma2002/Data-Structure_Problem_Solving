class Solution {
    // Main method to find the minimum number of people to teach a language
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> need = new HashSet<>(); // Set to store users who need to learn a new language

        // Iterate through each friendship pair
        for (int[] p : friendships) {
            int u = p[0] - 1, v = p[1] - 1; // Convert to 0-based index
            boolean ok = false; // Flag to check if they share a common language

            // Check if user u and user v share any language
            for (int x : languages[u]) {
                for (int y : languages[v]) {
                    if (x == y) {
                        ok = true; // They can communicate
                        break;
                    }
                }
                if (ok) break;
            }

            // If they cannot communicate, add both to the 'need' set
            if (!ok) {
                need.add(u);
                need.add(v);
            }
        }

        int ans = languages.length + 1; // Initialize answer with a large value

        // Try teaching each language from 1 to n
        for (int i = 1; i <= n; ++i) {
            int cans = 0; // Counter for people who need to learn language i

            // Check each person in 'need' set
            for (int v : need) {
                boolean found = false;
                // Check if person already knows language i
                for (int c : languages[v]) {
                    if (c == i) {
                        found = true;
                        break;
                    }
                }
                // If not, increment counter
                if (!found) cans++;
            }
            // Update answer with the minimum number found
            ans = Math.min(ans, cans);
        }
        return ans; // Return the minimum number of people to teach
    }
}
