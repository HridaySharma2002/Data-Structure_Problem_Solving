class Solution {
    public int rob(int[] nums) {
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

        /*
        //Tabulation
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,0);
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick=nums[i]+dp[i-2];
            }
            int not_pick=0+dp[i-1];

            dp[i]=Math.max(pick,not_pick);
        }

        return dp[n-1];
        */


        /*
        //Memoization
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return how(n-1,nums,dp);
        */
    }

    /*
    //Memoization
    int how(int ind,int[] nums,int dp[]){
        if(ind==0){
            return nums[ind];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }

        int pick=nums[ind]+how(ind-2,nums,dp);
        int not_pick=0+how(ind-1,nums,dp);

        return dp[ind]=Math.max(pick,not_pick);
    }*/
}
