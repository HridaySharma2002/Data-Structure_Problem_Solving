class Solution {
    public int minNumberOperations(int[] target) {
        // Start with the first element's value because we need at least this many increments
        // to raise the first element from 0 to target[0].
        int result = target[0];

        // Iterate through the target array starting from the second element
        for (int i = 1; i < target.length; i++) {
            // If the current element is greater than the previous one,
            // add the difference to the result because these many additional increments
            // are needed to raise the current element from target[i-1] to target[i].
            // If it's smaller or equal, no additional increments are needed for this position.
            result += Math.max(target[i] - target[i - 1], 0);
        }

        // Return the total minimum number of operations required
        return result;
    }
}
