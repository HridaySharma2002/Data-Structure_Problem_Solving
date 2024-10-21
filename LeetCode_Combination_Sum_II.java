class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        generate(0,candidates,target,new ArrayList<>(),result);
        return result;
    }

    public static void generate(int index,int arr[],int sum,List<Integer> current,List<List<Integer>> result){
        if(sum==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>sum){
                break;
            }

            current.add(arr[i]);
            generate(i+1,arr,sum-arr[i],current,result);
            current.remove(current.size()-1);
        }
    }
}
