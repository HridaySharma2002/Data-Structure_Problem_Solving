class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordset=new HashSet<>(wordDict);
        int n=s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;

        for(int i=0;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordset.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}