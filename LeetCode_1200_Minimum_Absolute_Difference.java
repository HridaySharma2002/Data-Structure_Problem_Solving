class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Sort the array in ascending order to bring elements with minimum differences closer
        Arrays.sort(arr);

        // Initialize mindiff to the maximum possible integer value
        // This will hold the minimum absolute difference found between any two adjacent elements
        int mindiff = Integer.MAX_VALUE;

        // Iterate through the sorted array to find the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            // Calculate the difference between current and previous element
            // Update mindiff if the current difference is smaller
            mindiff = Math.min(mindiff, arr[i] - arr[i - 1]);
        }

        // Prepare a list to store pairs of integers with the minimum absolute difference
        List<List<Integer>> result = new ArrayList<>();

        // Iterate again to collect all pairs that have the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            // Check if the difference between adjacent elements equals the minimum difference found
            if (arr[i] - arr[i - 1] == mindiff) {
                // Add the pair as a list to the result list
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }

        // Return the list of pairs with the minimum absolute difference
        return result;
    }
}
