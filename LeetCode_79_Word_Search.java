class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //Start a dfs search
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int i,int j,int index){
        if(index==word.length()){
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index)){
            return false;//Invalid Path
        }

        char temp=board[i][j];
        board[i][j]='#';//Mark the visited position as "#"

        //Searching at all positions
        boolean found=dfs(board,word,i+1,j,index+1) /*Searching down*/|| dfs(board,word,i-1,j,index+1)/*Searching Up*/ ||dfs(board,word,i,j+1,index+1)/* Searching right */ || dfs(board,word,i,j-1,index+1);/* Searching left*/

        board[i][j]=temp;//Restore the original value

        return found;
    }
}
