class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor=0;
        int count[]=new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    xor^=nums[j];
                }
            }
        }
        return xor;
    }
}
