class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans=1;
        List<Integer> ans_1=new ArrayList<>();
        ans_1.add(1);
        for(int i=0;i<rowIndex;i++){
            ans=ans*(rowIndex-i);
            ans=ans/(i+1);
            ans_1.add((int)ans);
        }
        return ans_1;
    }
}
