class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(),result);
        return result;
    }

    public  void backtrack(int index,int k,int n,List<Integer> combination,List<List<Integer>> result){
        if(combination.size()==k && n==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(combination.size() > k || n<0){
            return;
        }
        for(int i=index;i<=9;i++){
            combination.add(i);
            backtrack(i+1,k,n-i,combination,result);
            combination.remove(combination.size()-1);
        }
    }
}
