class Solution {
    public int totalMoney(int n) {
        int week = n / 7; // Number of complete weeks
        int day = n % 7;  // Remaining days
        // Calculate total using arithmetic sequence formulas
        return (week * (49 + 7 * week) + day * (2 * week + day + 1)) / 2;
    }
}
