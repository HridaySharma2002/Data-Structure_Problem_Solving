class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int Min=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){
                Min=Math.min(Min,nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]){
                Min=Math.min(Min,nums[low]);
                low=mid+1;
            }
            else{
                Min=Math.min(Min,nums[mid]);
                high=mid-1;
            }
        }
        return Min;
    }
}
