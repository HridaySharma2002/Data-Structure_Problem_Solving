class FindSumPairs {
    // Two integer arrays to store the input numbers
    int[] n1, n2;
    // A map to keep track of the frequency of elements in n2
    Map<Integer, Integer> map = new HashMap<>();

    // Constructor to initialize the class with two arrays
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1; // Assign nums1 to n1
        n2 = nums2; // Assign nums2 to n2
        // Populate the map with the frequency of each element in n2
        for (int x : n2) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    // Method to add a value to an element at a specific index in n2
    public void add(int index, int val) {
        // Decrease the count of the current value in the map
        map.put(n2[index], map.get(n2[index]) - 1);
        // Update the value at the specified index
        n2[index] += val;
        // Increase the count of the new value in the map
        map.put(n2[index], map.getOrDefault(n2[index], 0) + 1);
    }

    // Method to count how many pairs from n1 and n2 sum up to a given total
    public int count(int tot) {
        int count = 0; // Initialize the count of pairs
        // Iterate through each element in n1
        for (int x : n1) {
            // For each element x in n1, check how many times (tot - x) appears in n2
            count += map.getOrDefault(tot - x, 0);
        }
        return count; // Return the total count of pairs
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index, val); // Adds val to the element at index in n2
 * int param_2 = obj.count(tot); // Counts pairs that sum to tot
 */
