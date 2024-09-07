class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        // Fill dp array
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;  // Characters match, extend LCS
                } else {
             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  // Max LCS without current character
                }
            }
        }
        
        int lcs = dp[n][m];  
        return (n - lcs) + (m - lcs);  // Total deletions required
    }
}
