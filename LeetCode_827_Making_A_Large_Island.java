class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length; // Get the size of the grid
        DisjointSet ds = new DisjointSet(n * n); // Initialize a Disjoint Set for union-find operations

        // First pass: connect all 1s (island cells) in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue; // Skip water cells
                }
                int dr[] = {-1, 0, 1, 0}; // Direction vectors for up, left, down, right
                int dc[] = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int nrow = row + dr[ind];
                    int ncol = col + dc[ind];
                    // Check if the neighboring cell is within bounds
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
                        if (grid[nrow][ncol] == 1) { // If it's part of an island
                            int nodeNo = row * n + col; // Current cell's unique identifier
                            int adjnodeNo = nrow * n + ncol; // Neighboring cell's unique identifier
                            ds.unionbySize(nodeNo, adjnodeNo); // Union the two cells
                        }
                    }
                }
            }
        }

        int mx = 0; // Variable to track the maximum island size
        // Second pass: check each water cell to see the potential island size if it were turned into land
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue; // Skip island cells
                }
                int dr[] = {-1, 0, 1, 0}; // Direction vectors
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> set = new HashSet<>(); // To store unique parent identifiers of adjacent islands
                for (int ind = 0; ind < 4; ind++) {
                    int nrow = row + dr[ind];
                    int ncol = col + dc[ind];
                    // Check if the neighboring cell is within bounds
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
                        if (grid[nrow][ncol] == 1) { // If it's part of an island
                            set.add(ds.findUPar(nrow * n + ncol)); // Add the parent of the island to the set
                        }
                    }
                }
                int sizetotal = 0; // Total size of islands that can be connected
                for (Integer parents : set) {
                    sizetotal += ds.size.get(parents); // Sum the sizes of the unique islands
                }
                mx = Math.max(mx, sizetotal + 1); // Update max size considering the current water cell
            }
        }
        // Final check to ensure we consider the largest island size
        for (int ceil = 0; ceil < n * n; ceil++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(ceil))); // Check the size of each island
        }
        return mx; // Return the maximum island size found
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>(); // To keep track of the rank of each node
    List<Integer> parent = new ArrayList<>(); // To keep track of the parent of each node
    List<Integer> size = new ArrayList<>(); // To keep track of the size of each component

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0); // Initialize rank
            parent.add(i); // Each node is its own parent initially
            size.add(1); // Each component starts with size 1
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If the node is its own parent, return it
        }
        int ulp = findUPar(parent.get(node)); // Recursively find the ultimate parent
        parent.set(node, ulp); // Path compression
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v

        if (ulp_u == ulp_v) {
            return; // They are already in the same set
        }

        // Union by rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1); // Increase rank if they are of the same rank
        }
    }

    public void unionbySize(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v
        if (ulp_u == ulp_v) {
            return; // They are already in the same set
        }

        // Union by size
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v)); // Update size
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Update size
        }
    }
}
