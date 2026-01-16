class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Modulo value for large results as required by the problem
        long MOD = (long)1e9 + 7;
        // Variable to store the largest possible square side found
        long result = 0;

        // List to store all horizontal fence positions, including boundaries
        List<Integer> hlist = new ArrayList<>();
        // Add all internal horizontal fences
        for (int h : hFences) {
            hlist.add(h);
        }
        // Add the top and bottom boundaries (cannot be removed)
        hlist.add(1);
        hlist.add(m);

        // List to store all vertical fence positions, including boundaries
        List<Integer> vlist = new ArrayList<>();
        // Add all internal vertical fences
        for (int v : vFences) {
            vlist.add(v);
        }
        // Add the left and right boundaries (cannot be removed)
        vlist.add(1);
        vlist.add(n);

        // Set to store all unique possible horizontal distances (gaps between fences)
        Set<Integer> set = new HashSet<>();
        // Compute all possible distances between pairs of horizontal fences
        for (int i = 0; i < hlist.size(); i++) {
            for (int j = i + 1; j < hlist.size(); j++) {
                // The absolute difference gives the length of a possible square side
                set.add(Math.abs(hlist.get(j) - hlist.get(i)));
            }
        }

        // Now, for each possible vertical distance, check if it matches a horizontal distance
        for (int i = 0; i < vlist.size(); i++) {
            for (int j = i + 1; j < vlist.size(); j++) {
                int val = Math.abs(vlist.get(j) - vlist.get(i));
                // If this vertical gap matches a horizontal gap, a square of this side is possible
                if (set.contains(val)) {
                    // Update the result if this is the largest square side found so far
                    result = Math.max(result, val);
                }
            }
        }

        // If no valid square was found, return -1 as required by the problem
        if (result == 0) {
            return -1;
        }
        // Return the area of the largest square, modulo 1e9+7
        return (int)((result * result) % MOD);
    }
}
