class Solution {
    public int removeStones(int[][] stones) {
        int maxrow = 0; // Variable to track the maximum row index
        int maxcol = 0; // Variable to track the maximum column index

        // Determine the maximum row and column indices from the stones array
        for (int it[] : stones) {
            maxrow = Math.max(maxrow, it[0]); // Update maxrow if the current stone's row is greater
            maxcol = Math.max(maxcol, it[1]); // Update maxcol if the current stone's column is greater
        }

        // Initialize Disjoint Set with size sufficient for rows and columns
        DisjointSet ds = new DisjointSet(maxrow + maxcol + 2); // +2 to account for 0-based indexing
        HashMap<Integer, Integer> stonenodes = new HashMap<>(); // Map to track unique row and column nodes

        // Union rows and columns in the Disjoint Set
        for (int it[] : stones) {
            int nrow = it[0]; // Row index of the current stone
            int ncol = it[1] + maxrow + 1; // Column index adjusted for unique identification
            ds.unionbySize(nrow, ncol); // Union the row and column in the Disjoint Set
            stonenodes.put(nrow, 1); // Track unique row nodes
            stonenodes.put(ncol, 1); // Track unique column nodes
        }

        int cnt = 0; // Counter for unique components (roots)
        // Count the number of unique components (roots) in the Disjoint Set
        for (Map.Entry<Integer, Integer> it : stonenodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++; // Increment count for each unique root
            }
        }

        // The number of stones that can be removed is total stones minus the number of unique components
        return stones.length - cnt; // Return the result
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>(); // To keep track of the rank of each node
    List<Integer> parent = new ArrayList<>(); // To keep track of the parent of each node
    List<Integer> size = new ArrayList<>(); // To keep track of the size of each component

    // Constructor to initialize the Disjoint Set
    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0); // Initialize rank for each node
            parent.add(i); // Each node is its own parent initially
            size.add(1); // Each component starts with size 1
        }
    }

    // Method to find the ultimate parent of a node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If the node is its own parent, return it
        }
        int ulp = findUPar(parent.get(node)); // Recursively find the ultimate parent
        parent.set(node, ulp); // Path compression to optimize future queries
        return parent.get(node);
    }

    // Method to union two nodes by rank
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v

        if (ulp_u == ulp_v) {
            return; // They are already in the same set
        }

        // Union by rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); // Attach smaller rank tree under larger rank tree
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); // Attach smaller rank tree under larger rank tree
        } else {
            parent.set(ulp_v, ulp_u); // Attach one tree under the other
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1); // Increase rank if they are of the same rank
        }
    }

    // Method to union two nodes by size
    public void unionbySize(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v
        if (ulp_u == ulp_v) {
            return; // They are already in the same set
        }

        // Union by size
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); // Attach smaller size tree under larger size tree
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v)); // Update size
        } else {
            parent.set(ulp_v, ulp_u); // Attach smaller size tree under larger size tree
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Update size
        }
    }
}
