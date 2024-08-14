class Solution {
    public boolean isPalindrome(int x) {
        int rev_number=0;
        int dup=x;
       while(x>0){
        rev_number=(rev_number*10)+(x%10);
        x/=10;
       }
       if(rev_number==dup){
        return true;
       }else{
        return false;
       }
    }
}
