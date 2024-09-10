class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long val=(long)m*k;
        if(val>n){
            return -1;
        }
        int maxi=Integer.MIN_VALUE,mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }

        int low=mini,high=maxi;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean possible(int[] bloomDay,int day,int m,int k){
        int n=bloomDay.length;
        int count=0;
        int noOfB=0;
        //Count the Number of Bouquets
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                noOfB+=(count/k);
                count=0;
            }
        }
        noOfB+=(count/k);
        return noOfB >= m;
    }
}
