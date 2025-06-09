class Solution {
    // Method to determine the minimum number of operations to connect all computers
    public int makeConnected(int n, int[][] connections) {
        // Create a Disjoint Set (Union-Find) to manage connected components
        DisjointSet ds = new DisjointSet(n);
        int cntextra = 0; // Counter for extra connections

        // Process each connection
        for (int[] it : connections) {
            int u = it[0]; // Source computer
            int v = it[1]; // Destination computer
            // If u and v are already connected, increment the extra connection counter
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntextra++;
            } else {
                // Union the two computers
                ds.unionbySize(u, v);
            }
        }

        int cntC = 0; // Count of connected components
        // Count how many unique parents (connected components) exist
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                cntC++;
            }
        }
        
        // The number of operations needed to connect all components is (cntC - 1)
        int result = cntC - 1;
        // If we have enough extra connections to connect all components, return the result
        if (cntextra >= result) {
            return result;
        }

        // Not enough connections to connect all components
        return -1;
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>(); // Rank of each node
    List<Integer> parent = new ArrayList<>(); // Parent of each node
    List<Integer> size = new ArrayList<>(); // Size of each component

    // Constructor to initialize the disjoint set
    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0); // Initialize rank to 0
            parent.add(i); // Each node is its own parent initially
            size.add(1); // Initialize size to 1
        }
    }

    // Find the representative (ultimate parent) of a node
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If the node is its own parent, return it
        }
        // Path compression optimization
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Set the parent to the ultimate parent found
        return ulp;
    }

    // Union by rank
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return; // Already in the same set
        }

        // Union based on rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1); // Increase rank if both have the same rank
        }
    }

    // Union by size
    public void unionbySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) {
            return; // Already in the same set
        }

        // Union based on size
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
