class Solution {
    public int singleNumber(int[] nums) {
        //count_ones used to store element which appear only once
        int count_ones=0;
        //count_more_than_ones used to store element which appear more than once
        int count_more_than_ones=0;
        // XOR(^) Operator used to Add element
        // And(&) Operator used to check whether element is more than once
        // Negation(~) Operator used to toggle the element
        // And,Negation Combined used to remove the element
        for(int i=0;i<nums.length;i++){
            count_ones=(count_ones^nums[i])&~count_more_than_ones;
            count_more_than_ones=(count_more_than_ones^nums[i])&~count_ones;
        }
        return count_ones;
    }
}
