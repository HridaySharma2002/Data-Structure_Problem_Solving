class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;  // Variable to keep track of the maximum triangle area found
        int n = points.length;  // Number of points given
        
        // Iterate over all unique triplets of points (i, j, k)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Extract coordinates of the three points
                    int x1 = points[i][0];
                    int y1 = points[i][1];  
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    
                    // Calculate the area of the triangle using the shoelace formula:
                    // Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
                    double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                    
                    // Update maxArea if the current area is larger
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        // Return the largest triangle area found
        return maxArea;
    }
}
