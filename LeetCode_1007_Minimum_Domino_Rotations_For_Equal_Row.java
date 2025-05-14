class Solution {
    // Main function to find the minimum number of rotations
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Check for the two possible target values: tops[0] and bottoms[0]
        int result1 = check(tops, bottoms, tops[0]);
        int result2 = check(tops, bottoms, bottoms[0]);
        
        // Get the minimum result from the two checks
        int result = Math.min(result1, result2);
        
        // If both results are impossible, return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    // Helper function to check how many rotations are needed to make all values equal to target
    public int check(int[] tops, int[] bottoms, int target) {
        int rotationstop = 0; // Count of rotations needed for tops
        int rotationsbottom = 0; // Count of rotations needed for bottoms
        
        // Iterate through each domino
        for (int i = 0; i < tops.length; i++) {
            // If neither top nor bottom matches the target, return impossible
            if (tops[i] != target && bottoms[i] != target) {
                return Integer.MAX_VALUE;
            } 
            // Count rotations needed for tops
            else if (tops[i] != target) {
                rotationstop++;
            } 
            // Count rotations needed for bottoms
            else if (bottoms[i] != target) {
                rotationsbottom++;
            }
        }

        // Return the minimum rotations needed to make all equal to target
        return Math.min(rotationstop, rotationsbottom);
    }
}
