class Solution {
public void dfs(char[][] board, boolean[][] vis ,int i, int j ,int delrow[] , int delcol[] ){

    vis[i][j]=true;
    board[i][j]='T';

    for(int d=0;d<4;d++){
        int nrow = i+delrow[d];
        int ncol =j+delcol[d];

        if(nrow >=0 && nrow <board.length && ncol >=0 && ncol <board[0].length && board[nrow][ncol]=='O'&& !vis[nrow][ncol]){
            dfs(board,vis,nrow,ncol,delrow,delcol);
        }
    }
}

    public void solve(char[][] board) {
        if(board==null || board.length==0) return;

        int row = board.length;
        int col = board[0].length;

        boolean[][] vis = new boolean[row][col];

        int delrow[] ={-1,1,0,0};
        int delcol[] ={0,0,-1,1};

        for(int i=0;i<row;i++){

            if(board[i][0]=='O'&& !vis[i][0]){
                dfs(board,vis,i,0,delrow,delcol);
            }
            
            if(board[i][col-1]=='O'&& !vis[i][col-1]){
                dfs(board,vis,i,col-1,delrow,delcol);
            }
        }

         for(int j=0;j<col;j++){

            if(board[0][j]=='O'&& !vis[0][j]){
                dfs(board,vis,0,j,delrow,delcol);
            }
            
            if(board[row-1][j]=='O'&& !vis[row-1][j]){
                dfs(board,vis,row-1,j,delrow,delcol);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j] ='O';
                }
            }
        }


    }
}