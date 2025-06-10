class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Get the total number of accounts
        int n = accounts.size();
        
        // Create a Disjoint Set to manage merging of accounts
        DisjointSet ds = new DisjointSet(n);
        
        // HashMap to map email to its first encountered account index
        HashMap<String, Integer> mapmailNode = new HashMap<String, Integer>();
        
        // First pass: Identify and merge accounts with common emails
        for (int i = 0; i < n; i++) {
            // Iterate through emails in each account (skipping the name at index 0)
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                
                // If email is not seen before, map it to current account index
                if (!mapmailNode.containsKey(mail)) {
                    mapmailNode.put(mail, i);
                } 
                // If email is already seen, merge the current account with the previous account
                else {
                    ds.unionbySize(i, mapmailNode.get(mail));
                }
            }
        }

        // Create an array to store merged emails for each account
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        
        // Second pass: Collect emails for each merged account
        for (Map.Entry<String, Integer> it : mapmailNode.entrySet()) {
            String mail = it.getKey();
            // Find the ultimate parent (representative) of the account
            int node = ds.findUPar(it.getValue());
            // Add email to the list of the representative account
            mergedMail[node].add(mail);
        }

        // Prepare the final result
        List<List<String>> result = new ArrayList<>();

        // Process each merged account
        for (int i = 0; i < n; i++) {
            // Skip empty merged accounts
            if (mergedMail[i].size() == 0) {
                continue;
            }
            
            // Sort emails for each merged account
            Collections.sort(mergedMail[i]);
            
            // Create a new list for the merged account
            List<String> temp = new ArrayList<>();
            // Add the account name (first element of the original account)
            temp.add(accounts.get(i).get(0));
            
            // Add all merged emails to the list
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            
            // Add the merged account to the result
            result.add(temp);
        }

        return result;
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
