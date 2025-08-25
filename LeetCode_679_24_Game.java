class Solution {
    // Define a small epsilon value for floating point comparison
    final double EPS = 1e-6;

    // Main function to check if 24 can be obtained from the cards
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        // Convert each card to double and add to the list
        for (int num : cards) {
            nums.add((double) num);
        }
        // Start the recursive search
        return dfs(nums);
    }

    // Recursive function to try all combinations
    private boolean dfs(List<Double> nums) {
        // Base case: if only one number left, check if it's close to 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPS;
        }
        // Try every pair of numbers in the list
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // Skip if both indices are the same
                if (i == j) {
                    continue;
                }
                // Prepare the next list by removing the two selected numbers
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }
                // Try all possible results of combining nums[i] and nums[j]
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val); // Add the result to the list
                    // Recursively check if this leads to 24
                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1); // Backtrack
                }
            }
        }
        // If no combination leads to 24, return false
        return false;
    }

    // Compute all possible results of combining a and b with +, -, *, /
    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);     // Addition
        res.add(a - b);     // Subtraction
        res.add(b - a);     // Reverse subtraction
        res.add(a * b);     // Multiplication
        // Division, avoid division by zero using EPS
        if (Math.abs(b) > EPS) {
            res.add(a / b);
        }
        if (Math.abs(a) > EPS) {
            res.add(b / a);
        }
        return res;
    }
}
