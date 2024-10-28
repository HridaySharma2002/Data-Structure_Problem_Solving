class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();
        backtrack(result,"",num,target,0,0,0);
        return result;
    }

    public static void backtrack(List<String> result,String expression,String num,int target,int index,long currentval,long lastoperand){
        if(index==num.length()){
            if(currentval==target){
                result.add(expression);
            }
            return;
        }

        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(index)=='0'){
                break;
            }

            String currentnumstr=num.substring(index,i+1);
            long currentnum=Long.parseLong(currentnumstr);

            if(index==0){
                backtrack(result,currentnumstr,num,target,i+1,currentnum,currentnum);
            }
            else{
                backtrack(result,expression + "+" + currentnumstr,num,target,i+1,currentval+currentnum,currentnum);
                backtrack(result,expression + "-" + currentnumstr,num,target,i+1,currentval-currentnum,-currentnum);
                backtrack(result,expression + "*" + currentnumstr,num,target,i+1,currentval-lastoperand+(lastoperand*currentnum),lastoperand*currentnum);
            }
        }
    }
}
