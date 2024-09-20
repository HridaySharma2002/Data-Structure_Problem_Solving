class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0,high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int MaxRowIndex=peak(mat,mid);
            int left=mid-1>=0?mat[MaxRowIndex][mid-1]:-1;
            int right=mid+1<m?mat[MaxRowIndex][mid+1]:-1;
            if(mat[MaxRowIndex][mid]>left && mat[MaxRowIndex][mid]>right){
                return new int[] {MaxRowIndex,mid};
            }
            else if(mat[MaxRowIndex][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[] {-1,-1};
    }
    public static int peak(int[][] mat,int col){
        int n=mat.length;
        int m=mat[0].length;
        int max_value=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>max_value){
                max_value=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}
