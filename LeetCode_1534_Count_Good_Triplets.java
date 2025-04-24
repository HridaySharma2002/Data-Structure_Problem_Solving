class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // Initialize a counter for good triplets
        int count = 0;
        // Get the length of the array
        int n = arr.length;

        // Iterate through all possible triplets
        for (int i = 0; i < n - 2; i++) { // First element of the triplet
            for (int j = i + 1; j < n - 1; j++) { // Second element of the triplet
                for (int k = j + 1; k < n; k++) { // Third element of the triplet
                    // Check if the triplet satisfies the conditions
                    if (Math.abs(arr[i] - arr[j]) <= a && // Condition for arr[i] and arr[j]
                        Math.abs(arr[j] - arr[k]) <= b && // Condition for arr[j] and arr[k]
                        Math.abs(arr[i] - arr[k]) <= c) { // Condition for arr[i] and arr[k]
                        count++; // Increment the count if all conditions are met
                    }
                }
            }
        }

        // Return the total count of good triplets
        return count;
    }
}
