class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
      
      if(sum==0) return true;
      int n =arr.length;
      boolean dp[] = new boolean[sum+1];
      dp[0]=true;
      
    //   for(int i=1;i<=n;i++){
    //       for(int j=sum ;j>=0;j--){
              
    //           if(arr[i-1]<=j)
    //           dp[j]=(dp[j-arr[i-1]] || dp[j]);
    //       }
    //   }
      
      
      for(int i=0;i<n;i++){
          for(int j=sum ;j>=arr[i];j--){
              dp[j]=dp[j] || dp[j-arr[i]];
          }
      }
      return dp[sum];
    }
}