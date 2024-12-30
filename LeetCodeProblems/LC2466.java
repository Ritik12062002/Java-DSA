class Solution {

    int L,H,Z,O;
    int MOD =1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        L=low;
        H=high;
        Z=zero;
        O=one;
        int dp[] =new int[high +1 ];
        Arrays.fill(dp,-1);
        return slove(0,dp);
    }

    private int slove(int l ,int dp[]){
       if(l>H) return 0;
       if(dp[l] != -1) return dp[l];
 
        int addOne =0;
       
       if(l >= L && l<=H){
        addOne =1;
       }

       int appendZero = slove(l+Z , dp);
       int appendOne = slove(l+O ,dp);

       return dp[l] = (addOne + appendZero  + appendOne) %MOD;
    }
}