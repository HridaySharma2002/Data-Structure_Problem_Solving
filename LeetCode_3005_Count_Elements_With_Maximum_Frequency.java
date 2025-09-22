class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Create an array to store the frequency of each number (assuming numbers are in the range 1-100)
        int freq[] = new int[101];
        
        // Variables to keep track of the current maximum frequency and the result sum
        int max = 0;
        int result = 0;
        
        // Iterate through each number in the input array
        for (int num : nums) {
            // Increment the frequency of the current number
            int f = ++freq[num];
            
            // If the new frequency is greater than the current max, update max and reset result
            if (f > max) {
                max = f;
                result = f;
            }
            // If the new frequency equals the current max, add it to the result
            else if (f == max) {
                result += f;
            }
        }
        // Return the total frequencies of elements with the maximum frequency
        return result;
    }
}
