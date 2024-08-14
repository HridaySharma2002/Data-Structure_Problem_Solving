class Solution {
    
    public boolean isPalindrome(String s) {
        String end_2 = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start=0;
        int end=end_2.length()-1;
        while(start<end){
        if(end_2.charAt(start)!=end_2.charAt(end)){
            return false;
        }
            start++;
            end--;
        }
        return true;
        
    }
}
