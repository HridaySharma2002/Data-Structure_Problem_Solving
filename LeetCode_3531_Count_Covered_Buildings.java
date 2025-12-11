class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Initialize the result counter for covered buildings
        int result = 0;
        
        // PHASE 1: Find buildings with horizontal alignment (same y-coordinate)
        // Sort buildings by y-coordinate, then by x-coordinate for consistent ordering
        Arrays.sort(buildings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        // HashSet to store coordinates of buildings that have horizontal alignment
        // Format: "x,y" as a string for easy lookup
        HashSet<String> aligned = new HashSet<>();
        
        // Check each building (except first and last) for horizontal alignment
        for (int i = 1; i < buildings.length - 1; i++) {
            // If current building shares y-coordinate with both neighbors, it's horizontally aligned
            if (buildings[i][1] == buildings[i - 1][1] && buildings[i][1] == buildings[i + 1][1]) {
                aligned.add(buildings[i][0] + "," + buildings[i][1]);
            }
        }
        
        // PHASE 2: Find buildings with both horizontal AND vertical alignment
        // Re-sort buildings by x-coordinate, then by y-coordinate for vertical alignment check
        Arrays.sort(buildings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        // Check each building (except first and last) for vertical alignment
        for (int i = 1; i < buildings.length - 1; i++) {
            // If current building shares x-coordinate with both neighbors, it's vertically aligned
            if (buildings[i][0] == buildings[i - 1][0] && buildings[i][0] == buildings[i + 1][0]) {
                // If also horizontally aligned (from Phase 1), count as "covered"
                if (aligned.contains(buildings[i][0] + "," + buildings[i][1])) {
                    result++;
                }
            }
        }
        
        // Return the total count of covered buildings
        return result;
    }
}
