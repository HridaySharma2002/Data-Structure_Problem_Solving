class Solution {
    public int bestClosingTime(String customers) {
        int besttime = 0;      // Stores the best closing time found so far
        int minpenalty = 0;    // Stores the minimum penalty encountered so far
        int prefix = 0;        // Prefix sum to track penalty changes as we iterate

        // Iterate through each hour in the customers string
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i); // Get the customer status at hour i

            // If a customer comes ('Y'), staying open is good, so penalty decreases (-1)
            // If no customer ('N'), staying open is bad, so penalty increases (+1)
            prefix += ch == 'Y' ? -1 : 1;

            // If the current penalty is less than the minimum found so far,
            // update the best closing time and the minimum penalty
            if (prefix < minpenalty) {
                besttime = i + 1;      // Closing after this hour is better
                minpenalty = prefix;   // Update the minimum penalty
            }
        }
        // Return the best closing time found
        return besttime;
    }
}
