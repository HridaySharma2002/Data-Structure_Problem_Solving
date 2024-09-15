class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n){
            return -1;
        }
        int low=nums[0];
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(count(nums,mid)>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
        
    }
    public int count(int[] nums,int maxsum){
        int n=nums.length;
        int partitions=1;
        long subArraysum=0;
        for(int i=0;i<n;i++){
            if(subArraysum+nums[i]<=maxsum){
                subArraysum+=nums[i];
            }
            else{
                partitions++;
                subArraysum=nums[i];
            }
        }
        return partitions;
    }
}
