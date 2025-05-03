class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Create a set to find the number of distinct elements in the entire array
        HashSet<Integer> distinct_elements = new HashSet<>();
        for (int num : nums) {
            distinct_elements.add(num); // Add each number to the set
        }
        
        // Initialize count of complete subarrays and pointers for the sliding window
        int count = 0;
        int left = 0;
        HashMap<Integer, Integer> current_count = new HashMap<>();
        int totaldistinct = distinct_elements.size(); // Total distinct elements in the array
        
        // Use a sliding window approach to find complete subarrays
        for (int right = 0; right < nums.length; right++) {
            // Add the current number to the current_count map
            current_count.put(nums[right], current_count.getOrDefault(nums[right], 0) + 1);
            
            // Check if the current window has all distinct elements
            while (current_count.size() == totaldistinct) {
                // If it does, count all subarrays from left to right
                count += nums.length - right;
                
                // Remove the leftmost element from the window
                current_count.put(nums[left], current_count.get(nums[left]) - 1);
                // If the count of that element becomes zero, remove it from the map
                if (current_count.get(nums[left]) == 0) {
                    current_count.remove(nums[left]);
                }
                left++; // Move the left pointer to the right
            }
        }
        
        // Return the total count of complete subarrays
        return count;
    }
}
