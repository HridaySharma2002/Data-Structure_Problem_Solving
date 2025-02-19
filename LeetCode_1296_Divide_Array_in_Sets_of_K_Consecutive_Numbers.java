class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        // Step 1: Check if the total number of cards is divisible by k
        // If not, it's impossible to divide the cards into groups of size k
        if (nums.length % k != 0) {
            return false;
        }

        // Step 2: Count the frequency of each number using a TreeMap
        // TreeMap is used to keep the keys (number values) sorted
        TreeMap<Integer, Integer> count_num = new TreeMap<>();
        for (int num : nums) {
            // Increment the count for the current number
            count_num.put(num, count_num.getOrDefault(num, 0) + 1);
        }

        // Step 3: Try to form groups of size k
        while (!count_num.isEmpty()) {
            // Get the smallest number value (first key in the TreeMap)
            int first_num = count_num.firstKey();

            // Attempt to form a group starting from the smallest number
            for (int i = 0; i < k; i++) {
                int current_num = first_num + i; // The current number in the group

                // Check if the current number exists in the map
                if (!count_num.containsKey(current_num)) {
                    return false; // If the number is missing, we cannot form a valid group
                }

                // Decrease the count of the current number
                count_num.put(current_num, count_num.get(current_num) - 1);

                // If the count of the current number becomes zero, remove it from the map
                if (count_num.get(current_num) == 0) {
                    count_num.remove(current_num);
                }
            }
        }

        // If all numbers are successfully grouped, return true
        return true;
    }
}
