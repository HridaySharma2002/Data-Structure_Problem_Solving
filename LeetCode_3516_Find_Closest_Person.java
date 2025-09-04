class Solution {
    /**
     * Determines which person (Person 1 or Person 2) reaches Person 3 first on a number line.
     * 
     * @param x Position of Person 1
     * @param y Position of Person 2
     * @param z Position of Person 3 (does not move)
     * @return 1 if Person 1 arrives first,
     *         2 if Person 2 arrives first,
     *         0 if both arrive at the same time
     */
    public int findClosest(int x, int y, int z) {
        // Calculate the absolute distance between Person 1 and Person 3
        int distancePerson1 = Math.abs(x - z);
        
        // Calculate the absolute distance between Person 2 and Person 3
        int distancePerson2 = Math.abs(y - z);
        
        // Compare distances to determine who arrives first
        if (distancePerson1 < distancePerson2) {
            // Person 1 is closer and will arrive first
            return 1;
        } else if (distancePerson2 < distancePerson1) {
            // Person 2 is closer and will arrive first
            return 2;
        } else {
            // Both are equally distant and will arrive at the same time
            return 0;
        }
    }
}
