class Solution
{
    long countPS(String str)
    {
      int n =str.length();
      long dp[][] = new long[n][n];
      int MOD=1000000007;
      
      for(int i=0;i<n;i++) dp[i][i]=1;
      
      for(int len =2 ;len <=n ; len++){
          for(int i=0;i<= n-len ;i++){
              int j = i+len -1;
              
              if(str.charAt(i)== str.charAt(j)){
                  dp[i][j] = (dp[i+1][j] + dp[i][j-1]+1) % MOD;
              }else{
                  dp[i][j]= (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + MOD)%MOD;
              }
          }
      }
      
      return dp[0][n-1];
    }
}