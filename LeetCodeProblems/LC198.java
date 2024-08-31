class Solution {
    // public int rob(int[] nums) {
    //    int n = nums.length;
    //    int dp[] =new int[n+1];
    //    Arrays.fill(dp,-1);
    //    return memo( nums,n-1,dp);
    // }
    // public int memo(int[] nums ,int n ,int[] dp){
    //     if(n< 0) return 0;
    //     if(n==0) return nums[0];
    //     if(dp[n]!= -1) return dp[n];

    //     return dp[n] = Math.max(memo(nums,n-1,dp),nums[n] + memo(nums,n-2,dp));
    //  }

    public int rob(int[] nums) {
        int n =nums.length;
        if(n==0) return 0;
        if(n==1)return nums[0];
        
        int prev=0;
        int prev2=0;
        for(int i=0;i<n;i++){
            int curi =Math.max(prev,nums[i]+prev2);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}