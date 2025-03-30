class Solution {
    public int rob(int[] nums) {
        int n = nums.length; // Get the number of houses
        int arr1[] = new int[n]; // Array to consider robbing from the first house to the second last
        int arr2[] = new int[n]; // Array to consider robbing from the second house to the last

        // Handle edge case: if there's only one house, return its value
        if (n == 1) {
            return nums[0];
        }

        // Fill arr1 and arr2 based on the houses we can rob
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                arr1[i] = nums[i]; // Include current house in arr1 if it's not the first house
            }
            if (i != n - 1) {
                arr2[i] = nums[i]; // Include current house in arr2 if it's not the last house
            }
        }

        // Calculate the maximum money that can be robbed from both scenarios
        int ans1 = rob_approach(arr1); // Max money robbed considering arr1
        int ans2 = rob_approach(arr2); // Max money robbed considering arr2

        // Return the maximum of the two scenarios
        return Math.max(ans1, ans2);
    }

    public int rob_approach(int[] nums) {
        // Space Optimization
        int n = nums.length; // Get the number of houses
        if (n == 0) return 0; // Handle edge case: no houses
        if (n == 1) return nums[0]; // Handle edge case: only one house

        int prev = nums[0]; // Maximum money robbed up to the first house
        int prev2 = 0; // Maximum money robbed up to the house before the first

        // Iterate through the houses starting from the second
        for (int i = 1; i < n; i++) {
            int pick = nums[i]; // Money if we rob the current house
            if (i > 1) {
                pick += prev2; // Add the money from two houses back if applicable
            }
            int not_pick = prev; // Money if we do not rob the current house

            // Determine the maximum money that can be robbed up to the current house
            int curr = Math.max(pick, not_pick);
            prev2 = prev; // Update prev2 to the previous maximum
            prev = curr; // Update prev to the current maximum
        }

        return prev; // Return the maximum amount that can be robbed
    }
}
