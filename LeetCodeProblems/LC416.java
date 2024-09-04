class Solution {
    public boolean canPartition(int[] nums) {
         int totalSum = 0;
 
         // Calculate the sum of all elements
         for (int num : nums) {
             totalSum += num;
         }
 
         // If the total sum is odd, we cannot partition it into two equal subsets
         if (totalSum % 2 != 0) {
             return false;
         }
 
         int target = totalSum / 2;
         int n = nums.length;
         boolean[] dp = new boolean[target + 1];
         dp[0] = true;
 
       
         for (int num : nums) {
             for (int i = target; i >= num; i--) {
                 dp[i] = dp[i] || dp[i - num];
             }
         }
 
         return dp[target];
     }
 }