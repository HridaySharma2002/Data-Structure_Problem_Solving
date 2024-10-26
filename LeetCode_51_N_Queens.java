class Solution {
    public List<List<String>> solveNQueens(int n) {
    char[][] board=new char[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.';
        }
    }

    List<List<String>> result=new ArrayList<>();
    int leftRow[]=new int[n];
    int upperdiagonal[]=new int[2*n-1];
    int lowerdiagonal[]=new int[2*n-1];

    solve(0, board, result, leftRow, upperdiagonal, lowerdiagonal);
    return result;
    }
    private  List<String> construct(char[][] board){
    List<String> result=new LinkedList<>();
    for(int i=0;i<board.length;i++){
        String s=new String(board[i]);
        result.add(s);
    }

    return result;
}
    public void solve(int col,char[][] board,List<List<String>> result,int leftRow[],int upperdiagonal[],int lowerdiagonal[]){

    if(col==board.length){
        result.add(construct(board));
        return;
    }

    for(int row=0;row<board.length;row++){
        if(leftRow[row] == 0 && lowerdiagonal[row+col] == 0 && upperdiagonal[board.length - 1 +col - row]==0){
            board[row][col]='Q';
            leftRow[row]=1;
            lowerdiagonal[row+col]=1;
            upperdiagonal[board.length-1+col-row]=1;
            solve(col+1, board, result, leftRow, upperdiagonal, lowerdiagonal);
            board[row][col]='.';
            leftRow[row]=0;
            lowerdiagonal[row+col]=0;
            upperdiagonal[board.length-1+col-row]=0;
        }
    }

}
}
