class Solution {
    // Method to check if there are three consecutive odd numbers in the array
    public boolean threeConsecutiveOdds(int[] arr) {
        // If the array has less than 3 elements, return false
        if(arr.length < 3) {
            return false;
        }
        // Loop through the array, stopping 3 elements before the end
        for(int i = 0; i < arr.length - 2; i++) {
            // Check if the current element and the next two are all odd
            if((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
                return true; // Return true if three consecutive odds are found
            }
        }
        // Return false if no three consecutive odd numbers are found
        return false;
    }
}
