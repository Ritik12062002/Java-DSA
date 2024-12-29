class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int k = words[0].length();
        long MOD = 1_000_000_007;

        long[][] freq = new long[26][k];

        // Calculate the frequency of each character in every column
        for (int col = 0; col < k; col++) {
            for (String word : words) {
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }

        // Memoization table to store intermediate results
        Long[][] dp = new Long[m + 1][k + 1];

        return (int) (solve(0, 0, freq, target, m, k, dp, MOD) % MOD);
    }

    private long solve(int i, int j, long[][] freq, String target, int m, int k, Long[][] dp, long MOD) {
        if (i == m) return 1; // Formed the entire target
        if (j == k) return 0; // Exhausted all columns

        if (dp[i][j] != null) return dp[i][j];

        // Option 1: Do not take the current column
        long notTaken = solve(i, j + 1, freq, target, m, k, dp, MOD) % MOD;

        // Option 2: Take the current column (if the character matches)
        long taken = 0;
        if (freq[target.charAt(i) - 'a'][j] > 0) {
            taken = (freq[target.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, target, m, k, dp, MOD)) % MOD;
        }

        // Store the result in dp and return
        dp[i][j] = (notTaken + taken) % MOD;
        return dp[i][j];
    }
}

