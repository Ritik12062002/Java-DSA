//memoization

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n =text1.length();
        int m =text2.length();
        int dp[][] = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fn(n-1,m-1,text1,text2,dp);
    }

    public int fn(int i, int j ,String text1, String text2, int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i+1][j+1] != -1)  return dp[i+1][j+1];

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i+1][j+1] = 1+fn(i-1,j-1,text1,text2 ,dp);
        }

        return dp[i+1][j+1] = Math.max(fn(i-1,j,text1,text2,dp) , fn(i,j-1,text1,text2,dp));
    }
}


// tabulation

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];

        // Initialize the first row and first column with 0
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= m; j++) dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // No match
                }
            }
        }
        return dp[n][m];
    }
}