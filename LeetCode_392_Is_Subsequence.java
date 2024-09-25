class Solution {
    public boolean isSubsequence(String s, String t) {
        int S=s.length();
        int T=t.length();
        if(S==0){
            return true;
        }
        if(S>T){
            return false;
        }
        int j=0;
        for(int i=0;i<T;i++){
            if(t.charAt(i)==s.charAt(j)){
                if(j==S-1){
                    return true;
                }
                j+=1;
            }
        }
        return false;
    }
}
