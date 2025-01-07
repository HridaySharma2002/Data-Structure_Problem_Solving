class Solution {
    public int maxDepth(String s) {
        int maxdepth=0;//To keep track of maximum depth
        int currentdepth=0;//To keep track of cuurent depth

        //Iterate through each character of the String
        for(char c:s.toCharArray()){
            if(c=='('){
                //Increase the value of currentdepth when there is an open parentheses
                currentdepth++;
                //Upgrade the maxdepth if currentdepth is greater
                maxdepth=Math.max(maxdepth,currentdepth);
            }
            else if(c==')'){
                //Decrease the value of currentdepth when there is a closing parentheses
                currentdepth--;
            }
        }
        return maxdepth;
    }
}
