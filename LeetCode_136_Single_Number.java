class Solution {
    public int singleNumber(int[] nums) {
       int number=0;
       for(int i=0;i<nums.length;i++){
        // XOR of any Number with itself gives 0
        //Xor of any Number with 0 gives number itself
        number=number^nums[i];
       }
       return number;
    }
}