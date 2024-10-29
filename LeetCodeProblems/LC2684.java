class Solution {
    public int maxMoves(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        int dp[][] =new int[n][m];

        for(int i=0;i<n;i++) dp[i][0]=1;

        int maxMove =0;

        for(int j=1;j<m;j++){
            for(int i=0;i<n;i++){

              // Move from the Left
                if(grid[i][j] > grid[i][j-1]){
                    dp[i][j] =Math.max(dp[i][j], dp[i][j-1]);
                }
  
             // Move from the Top-Left
                if( i>0 && grid[i][j] > grid[i-1][j-1]){
                    dp[i][j] =Math.max(dp[i][j], dp[i-1][j-1]);
                }
 
               // Move from the Bottom-Left
                if( i< n-1 && grid[i][j] > grid[i+1][j-1]){
                    dp[i][j] =Math.max(dp[i][j], dp[i+1][j-1]);
                }

                // If any valid moves are possible, increment the move count for the cell
                if (dp[i][j] > 0) {
                    dp[i][j]++;
                }
            
            maxMove = Math.max(maxMove,dp[i][j]-1);
            }

        }
        return maxMove;
    }
}