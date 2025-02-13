class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Initialize counters for the number of 5 and 10 dollar bills
        int five = 0; // Counter for $5 bills
        int ten = 0;  // Counter for $10 bills
        
        // Iterate through each bill in the bills array
        for (int i = 0; i < bills.length; i++) {
            // If the customer pays with a $5 bill
            if (bills[i] == 5) {
                five++; // Increase the count of $5 bills
            }
            // If the customer pays with a $10 bill
            else if (bills[i] == 10) {
                // Check if we have a $5 bill to give as change
                if (five > 0) {
                    five--; // Use one $5 bill for change
                    ten++;   // Increase the count of $10 bills
                } else {
                    return false; // Cannot provide change, return false
                }
            }
            // If the customer pays with a $20 bill
            else {
                // Check if we can give one $10 and one $5 as change
                if (five > 0 && ten > 0) {
                    five--; // Use one $5 bill
                    ten--;   // Use one $10 bill
                }
                // If not, check if we can give three $5 bills as change
                else if (five >= 3) {
                    five -= 3; // Use three $5 bills
                } else {
                    return false; // Cannot provide change, return false
                }
            }
        }
        // If we successfully provided change for all customers, return true
        return true; // All customers were satisfied
    }
}
