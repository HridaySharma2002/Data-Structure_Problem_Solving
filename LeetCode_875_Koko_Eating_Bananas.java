class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findMax(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalh=ceil(piles,mid);
            if(totalh<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findMax(int[] piles){
        int n=piles.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    public int ceil(int[] piles,int hour){
        int n=piles.length;
        int totalh=0;
        for(int i=0;i<n;i++){
            totalh+=Math.ceil((double)(piles[i])/(double)(hour));
        }
        return totalh;
    }
}
