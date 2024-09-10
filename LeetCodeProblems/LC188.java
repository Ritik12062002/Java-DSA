class Solution {
    public int maxProfit(int k, int[] prices) {
        int n =prices.length;
        if(n==0) return 0;

        int dp[][][] =new int[n+1][k+1][2];

        for(int i=0;i<=k;i++){
            dp[n][i][0] =dp[n][i][1]=0;
        }

        for(int i=n-1;i>=0;i--){
         for(int j=1;j<=k;j++){
            for(int buy=0;buy<=1;buy++){

                int profit=0;
                if(buy==1){
                    profit =Math.max(-prices[i]+dp[i+1][j][0] , dp[i+1][j][1]);
                }
                else{
                    profit =Math.max(prices[i]+dp[i+1][j-1][1] , dp[i+1][j][0]);

                }

                dp[i][j][buy]=profit;
            }
         }
        }

        return dp[0][k][1];
    }
}