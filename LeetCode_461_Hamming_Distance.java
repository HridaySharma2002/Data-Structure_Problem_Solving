class Solution {
    public int hammingDistance(int x, int y) {
        int result=x^y;
        int count=0;
        for(int i=0;i<31;i++){
            if((result&(1<<i))!=0){
                count+=1;
            }
        }
        return count;
    }
}
