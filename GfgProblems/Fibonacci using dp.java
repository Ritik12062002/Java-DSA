class Solution {
    static int mod = (int)1e9 + 7;
    static long topDown(int n) {
        // code here
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        return memo(n,dp);
    }
    static long memo(int n, long[]dp)
    {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=(memo(n-1,dp)+memo(n-2,dp))%mod;
    }
    static long bottomUp(int n) {
        // code here
        int prev=1; int prev2=0;
        for(int i=2;i<=n;i++)
        {
            int cur=prev2+prev;
            prev2=prev;
            prev=cur%mod;
        }
        return prev;
    }
}
