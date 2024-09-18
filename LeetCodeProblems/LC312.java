class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] balloons = new int[n + 2];
        balloons[0] = balloons[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            balloons[i] = nums[i - 1];
        }

        int dp[][] = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxi = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = balloons[i - 1] * balloons[k] * balloons[j + 1] 
                             + dp[i][k - 1] + dp[k + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}
