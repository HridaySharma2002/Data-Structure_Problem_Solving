class Solution {
    public int findLucky(int[] arr) {
        // Create an array to store the frequency of numbers from 1 to 500
        int freq[] = new int[501];
        
        // Count the frequency of each number in the input array
        for (int num : arr) {
            freq[num]++;
        }
        
        // Iterate from 500 down to 1 to find the largest lucky number
        for (int i = 500; i >= 1; i--) {
            // Check if the frequency of the number equals the number itself
            if (freq[i] == i) {
                return i; // Return the lucky number if found
            }
        }
        
        // Return -1 if no lucky number is found
        return -1;
    }
}
