class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
      int maxProfit =0;
        int buy=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(prices[i]<buy){
                buy=prices[i];

            }

            else if(prices[i]-buy > maxProfit){
               maxProfit= prices[i]-buy;
            }
        }

       return maxProfit;
        
       
      
    }
}