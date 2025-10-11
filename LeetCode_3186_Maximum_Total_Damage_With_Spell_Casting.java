class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count the frequency of each spell power using a HashMap
        Map<Integer,Long> freq = new HashMap<>();
        for(int p : power){
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        // Step 2: Extract all unique spell powers and sort them
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        // Step 3: dp[i] will store the maximum total damage using the first i+1 unique spell powers
        long[] dp = new long[n];

        // Base case: Only the first unique spell power is considered
        dp[0] = freq.get(keys.get(0)) * keys.get(0);

        // Step 4: Iterate through each unique spell power
        for(int i = 1; i < n; i++){
            // Option 1: Take all spells of the current power
            long take = freq.get(keys.get(i)) * keys.get(i);

            // Find the last index j < i such that keys.get(j) <= keys.get(i) - 3
            // This ensures we don't violate the exclusion rule
            int prev = binarysearch(keys, i - 1, keys.get(i) - 3);

            // If such an index exists, add its dp value
            if(prev >= 0){
                take += dp[prev];
            }

            // Option 2: Skip the current power, take the best up to i-1
            dp[i] = Math.max(dp[i - 1], take);
        }

        // The answer is the maximum total damage using all unique spell powers
        return dp[n - 1];
    }

    // Helper function: Binary search to find the largest index <= end
    // where keys.get(index) <= value
    private int binarysearch(List<Integer> keys, int end, int value){
        int l = 0;
        int r = end;
        int result = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(keys.get(mid) <= value){
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
