class Solution {
    public int finalValueAfterOperations(String[] operations) {
        // If the input array is empty, return 0 as no operations are performed
        if (operations.length == 0) {
            return 0;
        }
        
        int result = 0;  // Initialize result to zero
        
        // Iterate through each operation in the array
        for (String operation : operations) {
            // If the operation is an increment (either postfix or prefix), increase result by 1
            if (operation.equals("X++") || operation.equals("++X")) {
                result++;
            } else {
                // Otherwise, the operation is a decrement, so decrease result by 1
                result--;
            }
        }
        
        // Return the final computed value after all operations
        return result;
    }
}
