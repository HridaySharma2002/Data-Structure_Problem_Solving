class Solution {
    public int reverse(int x) {
        long rev_num=0;
        while(x!=0){
            if(rev_num<Integer.MIN_VALUE/10||rev_num>Integer.MAX_VALUE/10){
            return 0;
        }
            rev_num=(rev_num*10)+(x%10);
            x/=10;
        }
        return (int)rev_num;
    }
}
