class Solution {
    public int[] singleNumber(int[] nums) {
        long number=0;
        for(int i=0;i<nums.length;i++){
            number^=nums[i];
        }
        long rightmost=(number&(number-1))^number;
        int b1=0, b2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&rightmost)!=0){
                b1^=nums[i];
            }
            else{
                b2^=nums[i];
            }
        }

        return new int[]{b1,b2};
    }
}
