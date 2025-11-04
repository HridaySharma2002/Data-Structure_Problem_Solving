class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        // Frequency array to count occurrences of numbers in the current window
        // Assuming numbers are in the range 1 to 50 inclusive
        int freq[] = new int[51];
        
        // List to store the sum results for each k-length subarray
        List<Integer> result = new ArrayList<>();
        
        // Initialize frequency array with the first window of size k
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }
        
        // Slide the window from start to end of the array
        for (int i = 0; i + k <= nums.length; i++) {
            // Create a list of pairs [value, frequency] for current window
            List<int[]> val = new ArrayList<>();
            for (int v = 1; v <= 50; v++) {
                // Add all values with their frequencies (including zero frequency)
                val.add(new int[]{v, freq[v]});
            }
            
            // Sort the list by frequency descending, then by value descending
            val.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
            
            // Calculate the sum of top x elements based on sorted order
            int sum = 0;
            for (int j = 0; j < x && j < val.size(); j++) {
                sum += val.get(j)[0] * val.get(j)[1];
            }
            
            // Add the computed sum for this window to the result list
            result.add(sum);
            
            // Update frequency array for sliding the window forward by one
            if (i + k < nums.length) {
                freq[nums[i]]--;       // Remove frequency of the element going out of the window
                freq[nums[i + k]]++;   // Add frequency of the new element coming into the window
            }
        }
        
        // Convert the result list to an int array before returning
        int res[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}
