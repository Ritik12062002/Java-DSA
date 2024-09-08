class Solution {
    public int longestCommonSubstr(String str1, String str2) {
       int n =str1.length();
       int m=str2.length();
       int res=0;
       int dp[][] =new int[n+1][m+1];
       
       for(int i=0;i<=n;i++) dp[i][0]=0;
     for(int j=0;j<=m;j++) dp[0][j]=0;
       
       
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){
               
               
               if(str1.charAt(i-1) == str2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1] +1;
                   res= Math.max(res,dp[i][j]);
               }else{
                   dp[i][j] =0;
               }
           }
       }
       
       return res;
       
    }
}