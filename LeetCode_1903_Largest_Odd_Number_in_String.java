class Solution {
    public String largestOddNumber(String num) {
        //Reverse Iterating
        for(int i=num.length()-1;i>=0;i--){
            //check if the current digit is odd
            if((num.charAt(i)-'0')%2!=0){
                //Return the substring from the start to the current index
                return num.substring(0,i+1);
            }
        }
        //Return an empty string if no odd number is found
        return "";
    }
}
