class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        // Create a list to store the boolean results
        List<Boolean> result = new ArrayList<>();
        // Initialize value to store the current prefix as an integer (modulo 5)
        int value = 0;
        // Iterate through each bit in the input array
        for (int num : nums) {
            // Left shift value by 1 (multiply by 2), add the current bit, then take modulo 5
            value = ((value << 1) + num) % 5;
            // If value is 0, the current prefix is divisible by 5; add the result to the list
            result.add(value == 0);
        }
        // Return the list of boolean results
        return result;
    }
}
