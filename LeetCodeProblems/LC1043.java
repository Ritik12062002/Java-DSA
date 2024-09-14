
// using Recursion

// class Solution {

//     public int fn(int ind, int[] arr, int k) {
//         int n = arr.length;
//         if (ind == n) return 0; 
        
//         int len = 0, maxi = Integer.MIN_VALUE;
//         int maxAns = Integer.MIN_VALUE;
        
//         for (int j = ind; j < Math.min(n, ind + k); j++) {
//              maxi = Math.max(maxi, arr[j]); 
            // int sum = (len * maxi) + fn(j + 1, arr, k); 
            // maxAns = Math.max(maxAns, sum);
//         }
//         return maxAns;
//     }

//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         return fn(0, arr, k);
//     }
// }

// using dp


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0, maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi) + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }

            dp[ind] = maxAns;
        }

        return dp[0];
    }
}
