
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        if (n <3) return 0;  //lbs must have atleast 3 length
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        
       //increasing 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
     //  decreasing 
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        
        
        int lbs = 0;
        for (int i = 0; i < n; i++) 
        {
            if (dp[i] > 1 && dp1[i] > 1) 
            lbs = Math.max(lbs, dp[i] + dp1[i] - 1);
        }
        
        return lbs;
    }
}
