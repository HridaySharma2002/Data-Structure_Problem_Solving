class Solution {
    public int maxDifference(String s) {
        // Initialize variables to track the minimum even frequency and maximum odd frequency
        int even_f_min = Integer.MAX_VALUE; // Start with the maximum possible value for even frequency
        int odd_f_max = Integer.MIN_VALUE;   // Start with the minimum possible value for odd frequency
        int[] map = new int[26];              // Array to count frequency of each character (assuming lowercase letters)

        // Count the frequency of each character in the input string
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++; // Increment the count for the corresponding character
        }

        // Iterate through the frequency array to find the min even and max odd frequencies
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 != 0) {
                // If the frequency is odd, update the maximum odd frequency
                odd_f_max = Math.max(odd_f_max, map[i]);
            } else if (map[i] % 2 == 0 && map[i] > 0) {
                // If the frequency is even and greater than zero, update the minimum even frequency
                even_f_min = Math.min(even_f_min, map[i]);
            }
        }

        // Return the difference between the maximum odd frequency and minimum even frequency
        return odd_f_max - even_f_min;
    }
}
