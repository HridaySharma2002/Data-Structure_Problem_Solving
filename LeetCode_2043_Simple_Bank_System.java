class Bank {
    // Array to store the balance of each account. Index 0 corresponds to account 1.
    private final long[] bal;
    // Total number of accounts in the bank.
    private final int n;

    /**
     * Constructor to initialize the bank with the given balances.
     * @param balance Array of initial balances for each account.
     */
    public Bank(long[] balance) {
        this.bal = balance;
        this.n = balance.length;
    }
    
    /**
     * Transfers money from account1 to account2 if possible.
     * @param account1 The source account number (1-indexed).
     * @param account2 The destination account number (1-indexed).
     * @param money The amount to transfer.
     * @return true if the transfer is successful, false otherwise.
     */
    public boolean transfer(int account1, int account2, long money) {
        // Check if both accounts are valid and account1 has enough balance.
        if (!valid(account1) || !valid(account2) || bal[account1 - 1] < money) {
            return false;
        }
        // Perform the transfer.
        bal[account1 - 1] -= money;
        bal[account2 - 1] += money;
        return true;
    }
    
    /**
     * Deposits money into the specified account.
     * @param account The account number (1-indexed).
     * @param money The amount to deposit.
     * @return true if the deposit is successful, false otherwise.
     */
    public boolean deposit(int account, long money) {
        // Check if the account is valid.
        if (!valid(account)) {
            return false;
        }
        // Add the money to the account.
        bal[account - 1] += money;
        return true;
    }
    
    /**
     * Withdraws money from the specified account if possible.
     * @param account The account number (1-indexed).
     * @param money The amount to withdraw.
     * @return true if the withdrawal is successful, false otherwise.
     */
    public boolean withdraw(int account, long money) {
        // Check if the account is valid and has enough balance.
        if (!valid(account) || bal[account - 1] < money) {
            return false;
        }
        // Subtract the money from the account.
        bal[account - 1] -= money;
        return true;
    }

    /**
     * Helper method to check if an account number is valid.
     * @param account The account number (1-indexed).
     * @return true if the account number is valid, false otherwise.
     */
    private boolean valid(int account) {
        return account > 0 && account <= n;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
