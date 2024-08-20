import java.util.Set;
import java.util.HashSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int longest=1;
        //Adding Elements into Set
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        //Finding the Longest Sequence
        for(int it:set){
            //If 'it' is a starting number
            if(!set.contains(it-1)){
                //find consecutive number
                int count=1;
                int x=it;
                while(set.contains(x+1)){
                    x+=1;
                    count+=1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}
