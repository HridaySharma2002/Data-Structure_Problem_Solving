class Solution {
    public boolean isAnagram(String s, String t) {
        //Check the length of the String
        if(s.length()!=t.length()){
            return false;
        }

        //Creating an Array to count the occurrences of character in a String
        int[] char_count=new int[26];

        //Count Characters in s and t
        for(int i=0;i<s.length();i++){
            //Increment Count for Character s
            char_count[s.charAt(i)-'a']++;
            //Decrement Count for Character t
            char_count[t.charAt(i)-'a']--;
        }

        //Check if all the counts are zero
        for(int count:char_count){
            if(count!=0){
                //If count is not zero then it is not Anagram
                return false;
            }
        }

        //All counts are zero , so it is Anagram
        return true;
    }
}
