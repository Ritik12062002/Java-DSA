class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int rows =mat.length;
        int cols =mat[0].length;

        int low =0,high=cols-1;

        while(low<=high){

            int  mid=(low+high) /2;

            int row =getMaxRowIndex(mat,mid);

            if(mid >0 && mat[row][mid] < mat[row][mid-1]){
                high =mid-1;
            }
            else if(mid < cols-1 && mat[row][mid] < mat[row][mid+1]){
                low=mid+1;
            }else{
                return new int[]{row,mid};
            }
        }

        return new int[]{-1,-1};
    }

    public int getMaxRowIndex(int mat[][] , int col){
        int max =Integer.MIN_VALUE;
        int maxIndex=-1;

        for(int i=0;i<mat.length;i++){
        
        if(mat[i][col] >max){
            max=mat[i][col];
            maxIndex=i;
        }

        }

        return maxIndex;
    }
}