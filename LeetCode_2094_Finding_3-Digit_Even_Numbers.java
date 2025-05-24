class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // Create a list to store valid even numbers
        List<Integer> evenNumber = new ArrayList<>();
        
        // Create an array to count occurrences of each digit (0-9)
        int digit_count[] = new int[10];
        
        // Count the occurrences of each digit in the input array
        for(int digit : digits){
            digit_count[digit]++;
        }

        // Iterate through all three-digit even numbers (100 to 998)
        for(int num = 100; num < 1000; num += 2){
            // Create a temporary array to count digits of current number
            int[] current_digit_count = new int[10];
            
            // Extract and count digits of the current number
            int temp = num;
            while(temp > 0){
                // Get the last digit and increment its count
                current_digit_count[temp % 10]++;
                
                // Remove the last digit
                temp /= 10;
            }

            // Check if the current number can be formed using available digits
            if(canMakeDigitCount(digit_count, current_digit_count)){
                evenNumber.add(num);
            }
        }

        // Convert the list of even numbers to an array and return
        return evenNumber.stream().mapToInt(Integer::intValue).toArray();
    }

    //Checks if a number can be formed using the available digits
     
    public boolean canMakeDigitCount(int[] available_count, int[] required_count){
        // Check if each digit's required count is less than or equal to available count
        for(int i = 0; i < 10; i++){
            if(required_count[i] > available_count[i]){
                return false;
            }
        }
        return true;
    }
}
