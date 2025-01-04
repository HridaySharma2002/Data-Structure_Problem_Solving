class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Check if the length of the Strings are same or not
        if(s.length()!=t.length()){
            return false;
        }

        //Creating two arrays to mapping all characters of ASCII each
        int[] sTot=new int[256];
        int[] tTos=new int[256];

        //Iterate both the Arrays
        for(int i=0;i<s.length();i++){
            char charS=s.charAt(i);
            char charT=t.charAt(i);

            //Check for Mapping from s to t
            if(sTot[charS]==0 && tTos[charT]==0){
                //If they are not mapped yet start the new mapping
                sTot[charS]=charT;
                tTos[charT]=charS;
            }
            //If there is a mismatch in the mapping return false
            else if(sTot[charS]!=charT || tTos[charT]!=charS){
                return false;
            }
        }

        //If all the characters mapped correctly return true
        return true;
    }
}
