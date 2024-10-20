class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        generate(0,candidates,target,new ArrayList<>(),result);
        return result;
    }

    public  void generate(int index,int arr[],int sum,List<Integer> current,List<List<Integer>> result){
        if(index==arr.length){
            if(sum==0){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if(arr[index]<=sum){
            current.add(arr[index]);
            generate(index,arr,sum-arr[index],current,result);
            current.remove(current.size()-1);
        }
        generate(index+1,arr,sum,current,result);
    }
}
