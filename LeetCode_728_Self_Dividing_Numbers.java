class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        // Initialize a list to store the self-dividing numbers in the given range
        List<Integer> result = new ArrayList<>();
        
        // Iterate through each number from left to right (inclusive)
        for(int i = left; i <= right; i++){
            // Check if the current number is self-dividing
            if(check(i)){
                // If yes, add it to the result list
                result.add(i);
            }
        }
        // Return the list of all self-dividing numbers found
        return result;
    }
    
    // Helper method to check if a number is self-dividing
    private boolean check(int value){
        int num = value;
        
        // Process each digit of the number
        while(num != 0){
            int rem = num % 10; // Extract the last digit
            
            // If the digit is 0 or the original number is not divisible by this digit,
            // then it is not a self-dividing number
            if(rem == 0 || value % rem != 0){
                return false;
            }
            
            num /= 10; // Remove the last digit and continue checking
        }
        
        // If all digits divide the number evenly, return true
        return true;
    }
}
