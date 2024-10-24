class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        partitioning(0,s,new ArrayList<>(),result);
        return result;
    }

    public void partitioning(int index,String s,List<String> current,List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                partitioning(i+1,s,current,result);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
