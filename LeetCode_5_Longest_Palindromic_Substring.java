class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1){
            return "";
        }

        //To keep track of starting and ending position of substring
        int start=0,end=0;

        for(int i=0;i<s.length();i++){
            //length of odd palindrome substring
            int len1=expand_around_centre(s,i,i);
            //length of even palindrome substring
            int len2=expand_around_centre(s,i,i+1);
            //Get the max length among odd and even palindrome substring
            int len=Math.max(len1,len2);

            //Update the start and end index if a longer palindrome is found
            if(len>end-start){
                start= i-((len-1)>>1);
                end=i+(len>>1);
            }
        }

        return s.substring(start,end+1);
    }
    private int expand_around_centre(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //length of the palindrome
        return right-left-1;
    }
}
