class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<n;i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(findDays(weights,mid)<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int findDays(int[] weights,int cap){
        int n=weights.length;
        int load=0;
        int days=1;
        for(int i=0;i<n;i++){
            if(load+weights[i]>cap){
                days+=1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
}
