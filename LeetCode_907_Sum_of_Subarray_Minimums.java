class Solution {
    // This method calculates the sum of the minimum values of all subarrays of the given array 'arr'.
    public int sumSubarrayMins(int[] arr) {
        // Define a large prime number for modulo operations to prevent overflow.
        int mod = (int)(1e9 + 7);
        
        // Get the indices of the next smaller elements for each element in the array.
        int nse[] = nse(arr);
        
        // Get the indices of the previous smaller elements for each element in the array.
        int pse[] = pse(arr);
        
        // Initialize a variable to accumulate the total sum of minimums.
        long sum = 0;
        
        // Iterate through each element in the array to calculate its contribution to the total sum.
        for (int i = 0; i < arr.length; i++) {
            // Calculate the number of subarrays that end at index 'i'.
            int left = i - pse[i];
            
            // Calculate the number of subarrays that start at index 'i'.
            int right = nse[i] - i;
            
            // Update the total sum by adding the contribution of arr[i].
            // The contribution is calculated as the product of the number of subarrays
            // that can be formed with arr[i] as the minimum.
            sum = (sum+(long)left * right * arr[i]) % mod;
        }
        
        // Return the total sum as an integer.
        return (int)sum;
    }

    // This method finds the indices of the next smaller elements for each element in the array.
    public int[] nse(int[] arr) {
        // Create an array to store the next smaller elements' indices.
        int[] NSE = new int[arr.length];
        
        // Use a stack to keep track of indices while iterating from right to left.
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the last element to the first.
        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from the stack while the top element is greater than or equal to arr[i].
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no smaller element to the right,
            // so we set NSE[i] to the length of the array.
            // Otherwise, set NSE[i] to the index of the next smaller element.
            NSE[i] = stack.isEmpty() ? arr.length : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of next smaller elements' indices.
        return NSE;
    }

    // This method finds the indices of the previous smaller elements for each element in the array.
    public int[] pse(int[] arr) {
        // Create an array to store the previous smaller elements' indices.
        int[] PSE = new int[arr.length];
        
        // Use a stack to keep track of indices while iterating from left to right.
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the first element to the last.
        for (int i = 0; i < arr.length; i++) {
            // Pop elements from the stack while the top element is greater than arr[i].
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no smaller element to the left,
            // so we set PSE[i] to -1.
            // Otherwise, set PSE[i] to the index of the previous smaller element.
            PSE[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of previous smaller elements' indices.
        return PSE;
    }
}
