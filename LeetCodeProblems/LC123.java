class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        
        int dp[][][] = new int[n+1][3][2];
        
      
        for (int k = 0; k <= 2; k++) {
            dp[n][k][0] = dp[n][k][1] = 0;  
        }
        
        
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 2; k++) {  
                for (int buy = 0; buy <= 1; buy++) {
                    int profit = 0;
                    if (buy == 1) {
                     
                        profit = Math.max(-prices[i] + dp[i + 1][k][0], 0 + dp[i + 1][k][1]);
                    } else {
                     
                        profit = Math.max(prices[i] + dp[i + 1][k - 1][1], 0 + dp[i + 1][k][0]);
                    }
                    dp[i][k][buy] = profit;
                }
            }
        }
        
   
        return dp[0][2][1];
    }
}
