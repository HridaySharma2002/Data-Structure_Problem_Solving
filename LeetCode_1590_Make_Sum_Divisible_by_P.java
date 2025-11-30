class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        // Calculate the total sum of the array
        for (int num : nums) {
            total += num;
        }
        // Find the remainder when total is divided by p
        long target = total % p;
        // If the sum is already divisible by p, no need to remove any subarray
        if (target == 0) {
            return 0;
        }
        // Map to store prefix sum modulo p and its latest index
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize with 0 remainder at index -1 (before array starts)
        map.put(0, -1);
        long prefix = 0;
        int result = nums.length;
        // Iterate through the array to find the minimal subarray to remove
        for (int i = 0; i < nums.length; i++) {
            // Update prefix sum modulo p
            prefix = (prefix + nums[i]) % p;
            // Calculate the needed prefix sum to find a valid subarray
            int need = (int) ((prefix - target + p) % p);
            // If such a prefix sum exists, update the result with the minimal length
            if (map.containsKey(need)) {
                result = Math.min(result, i - map.get(need));
            }
            // Store the current prefix sum modulo p with its index
            map.put((int) prefix, i);
        }
        // If result is not updated, return -1 (not possible), else return result
        return result == nums.length ? -1 : result;
    }
}
