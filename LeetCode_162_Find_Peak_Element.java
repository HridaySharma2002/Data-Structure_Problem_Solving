class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        //Edge Cases
        if(n==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }

        int low=1,high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;

            //If nums[mid] is in the peak
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }

            //If we are in the left
            else if(nums[mid]>nums[mid-1]){
                low=mid+1;
            }

            //If we are in the right
            //Or
            //nums[mid] is a common point
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}