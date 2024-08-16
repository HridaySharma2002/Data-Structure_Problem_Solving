class Solution {
    public int missingNumber(int[] nums) {
        int sum=(nums.length*(nums.length+1))/2;
        int arr_sum=0;
        for(int i=0;i<nums.length;i++){
            arr_sum+=nums[i];
        }
        return sum-arr_sum;
    }
}
