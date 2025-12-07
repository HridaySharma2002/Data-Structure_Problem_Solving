class Solution {
    public int countOdds(int low, int high) {
        // Count of odds from 1 to high: (high + 1) / 2
        // Count of odds from 1 to low-1: (low / 2)
        // Subtract to get odds in [low, high]
        return (high + 1) / 2 - (low / 2);
    }
}
