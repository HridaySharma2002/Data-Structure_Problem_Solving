class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char it:s.toCharArray()){
            //Store the Opening Parenthesis
            if(it=='(' || it=='{' || it=='['){
                st.push(it);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                
                char c=st.pop();
                //Check for Matching Brackets
                if((it==')' && c=='(') || (it=='}' && c=='{') ||( it==']' && c=='[')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
