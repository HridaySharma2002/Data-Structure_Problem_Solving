import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map <Integer,Integer> mpp=new HashMap<>();
        int presum=0,count=0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            presum+=nums[i];
            int remove=presum-k;
            count+=mpp.getOrDefault(remove,0);
            mpp.put(presum,mpp.getOrDefault(presum,0)+1);
        }

        return count;
    }
}
