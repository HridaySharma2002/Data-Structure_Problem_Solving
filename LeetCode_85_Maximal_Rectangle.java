class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max_area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Update heights based on the current row
                heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
            }
            // Calculate the maximum area for the current histogram
            max_area = Math.max(max_area, largestRectangleArea(heights));
        }
        return max_area;
    }

    // Helper function to calculate the largest rectangle area in a histogram
    private int largestRectangleArea(int[] heights) {
        int max_area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max_area = Math.max(max_area, height * width);
            }
            stack.push(i);
        }
        return max_area;
    }
}
