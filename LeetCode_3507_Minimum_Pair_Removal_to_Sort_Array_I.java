class Solution {
    public int minimumPairRemoval(int[] nums) {
        // Convert the input array to a List<Integer> for easier manipulation (removal and update)
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int count = 0; // Counter for the number of pair removals performed

        // Repeat until the list is sorted in non-decreasing order
        while (!isSorted(list)) {
            int minsum = Integer.MAX_VALUE; // Initialize minsum to a very large value
            int ind = 0; // Index of the pair with the minimum sum

            // Find the adjacent pair with the smallest sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minsum) {
                    minsum = sum;
                    ind = i;
                }
            }

            // Replace the first element of the pair with their sum
            list.set(ind, minsum);
            // Remove the second element of the pair, effectively merging the pair into one element
            list.remove(ind + 1);

            count++; // Increment the count of removals
        }

        // Return the total number of pair removals needed to sort the array
        return count;
    }

    // Helper method to check if the list is sorted in non-decreasing order
    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            // If any element is smaller than the previous one, list is not sorted
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true; // List is sorted
    }
}
