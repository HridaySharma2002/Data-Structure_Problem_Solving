class Solution {
    public String reverseWords(String s) {
        //Trimming and Splitting the String
        String[] str=s.trim().split("\\s+");
        String result="";
        // Reversing the Words
        for(int i=str.length-1;i>0;i--){
            result+=str[i]+" ";
        }

        //Adding the first word as the loop does not include the first word, ensuring that the final output is correctly formatted
        return result+str[0];
    }
}
