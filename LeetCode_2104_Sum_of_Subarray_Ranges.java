class Solution {
    // This method calculates the difference between the sum of maximum and minimum values of all subarrays.
    public long subArrayRanges(int[] nums) {
        // Define a large prime number for modulo operations to prevent overflow.
        long mod = (long)(1e16 + 7);
        
        // Initialize variables to accumulate the sum of minimum and maximum values.
        long sum_min = 0;
        long sum_max = 0;
        
        // Get the indices of the next smaller elements for each element in the array.
        long[] nse = nse(nums);
        
        // Get the indices of the previous smaller elements for each element in the array.
        long[] pse = pse(nums);
        
        // Get the indices of the next greater elements for each element in the array.
        long[] nge = nge(nums);
        
        // Get the indices of the previous greater elements for each element in the array.
        long[] pge = pge(nums);
        
        // Iterate through each element in the array to calculate its contribution to the total sums.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the number of subarrays that end at index 'i' for minimum calculations.
            long left_min = i - pse[i];
            long right_min = nse[i] - i;
            
            // Calculate the number of subarrays that start at index 'i' for maximum calculations.
            long left_max = i - pge[i];
            long right_max = nge[i] - i;
            
            // Update the total sum of minimums by adding the contribution of nums[i].
            sum_min = (sum_min + (long)left_min * right_min * nums[i]) % mod;
            
            // Update the total sum of maximums by adding the contribution of nums[i].
            sum_max = (sum_max + (long)left_max * right_max * nums[i]) % mod;
        }

        // Return the difference between the total sum of maximums and minimums.
        return (long)(sum_max - sum_min);
    }

    // This method finds the indices of the next smaller elements for each element in the array.
    public long[] nse(int[] nums) {
        long nse[] = new long[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the last element to the first.
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from the stack while the top element is greater than or equal to nums[i].
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no smaller element to the right,
            // so we set nse[i] to the length of the array.
            nse[i] = stack.isEmpty() ? nums.length : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of next smaller elements' indices.
        return nse;
    }

    // This method finds the indices of the previous smaller elements for each element in the array.
    public long[] pse(int[] nums) {
        long[] pse = new long[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the first element to the last.
        for (int i = 0; i < nums.length; i++) {
            // Pop elements from the stack while the top element is greater than nums[i].
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no smaller element to the left,
            // so we set pse[i] to -1.
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of previous smaller elements' indices.
        return pse;
    }

    // This method finds the indices of the next greater elements for each element in the array.
    public long[] nge(int[] nums) {
        long[] nge = new long[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the last element to the first.
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from the stack while the top element is less than nums[i].
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no greater element to the right,
            // so we set nge[i] to the length of the array.
            nge[i] = stack.isEmpty() ? nums.length : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of next greater elements' indices.
        return nge;
    }

    // This method finds the indices of the previous greater elements for each element in the array.
    public long[] pge(int[] nums) {
        long[] pge = new long[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from the first element to the last.
        for (int i = 0; i < nums.length; i++) {
            // Pop elements from the stack while the top element is less than or equal to nums[i].
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            // If the stack is empty, it means there is no greater element to the left,
            // so we set pge[i] to -1.
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current index onto the stack.
            stack.push(i);
        }
        
        // Return the array of previous greater elements' indices.
        return pge;
    }
}
