class Solution {
    public boolean isPowerOfTwo(int n) {
        //Check if the number is less than or equal to zero
        if(n<=0){
            return false;
        }
        //Check if the number is a power of 2 or not
        return ((n&(n-1))==0);
    }
}
