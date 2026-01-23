class Solution {
    // Number of inversions (pairs where left element > right element)
    private long flipped;
    // Arrays to keep track of the left and right neighbors of each element
    private int[] left;
    private int[] right;
    // TreeSet to store pairs of adjacent elements by their sum and index, sorted by sum then index
    private TreeSet<long[]> pairsum;

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        // If array has less than 2 elements, no removals needed
        if (n < 2) {
            return 0;
        }
        // Convert input array to long array for safe sum operations
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        flipped = 0;
        left = new int[n];
        right = new int[n];
        // Initialize TreeSet with custom comparator to sort by sum, then by index
        pairsum = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        // Initialize left and right neighbor indices for each element
        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }

        // Count initial inversions and add all adjacent pairs to pairsum
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                flipped++;
            }
            pairsum.add(new long[]{arr[i] + arr[i + 1], i});
        }

        int count = 0; // Count of pairs removed
        // While there are inversions and pairs to process
        while (flipped > 0 && !pairsum.isEmpty()) {
            // Get the pair with the smallest sum
            long[] first = pairsum.pollFirst();
            int i = (int) first[1];
            int j = right[i]; // right neighbor of i
            int h = left[i];  // left neighbor of i
            int k = right[j]; // right neighbor of j

            // Remove pairs involving h and i from pairsum
            remove(h, n, arr);
            // If this pair was an inversion, decrement flipped count
            if (arr[i] > arr[j]) {
                flipped--;
            }
            // Remove pairs involving j from pairsum
            remove(j, n, arr);

            // Merge elements at i and j by summing their values
            arr[i] += arr[j];
            count++; // Increment removal count

            // Update right pointer of i to skip j
            right[i] = k;
            // Update left pointer of k to point back to i if k is valid
            if (k < n) {
                left[k] = i;
            }

            // Add updated pairs involving h and i back to pairsum
            add(h, n, arr);
            add(i, n, arr);
        }
        return count;
    }

    // Add pairs involving index 'ind' back to pairsum if valid
    private void add(int ind, int n, long arr[]) {
        if (ind >= 0 && ind < n) {
            int j = right[ind];
            if (j < n) {
                pairsum.add(new long[]{arr[ind] + arr[j], ind});
                // If this pair is an inversion, increment flipped count
                if (arr[ind] > arr[j]) {
                    flipped++;
                }
            }
        }
    }

    // Remove pairs involving index 'ind' from pairsum if present
    private void remove(int ind, int n, long arr[]) {
        if (ind >= 0 && ind < n) {
            int j = right[ind];
            if (j < n) {
                long[] target = new long[]{arr[ind] + arr[j], ind};
                // Only remove if the pair exists in pairsum
                if (pairsum.contains(target)) {
                    // If this pair was an inversion, decrement flipped count
                    if (arr[ind] > arr[j]) {
                        flipped--;
                    }
                    pairsum.remove(target);
                }
            }
        }
    }
}
