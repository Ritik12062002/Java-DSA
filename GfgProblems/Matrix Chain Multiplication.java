// recursion

class Solution{
    
    static int fn(int i, int j, int arr[]){
        if(i==j) return 0;
        int mini=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            int steps= arr[i-1]*arr[k]*arr[j] + fn(i,k,arr) + fn(k+1,j,arr);
            if(steps<mini) mini =steps;
            // mini= Math.min(mini,steps);
        }
        
        return mini;
    }
    
    
    static int matrixMultiplication(int N, int arr[])
    {
       return fn(1,N-1,arr);
    }
}


// mempization

class Solution{
    
    static int fn(int i, int j, int arr[],  int dp[][]){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            int steps= arr[i-1]*arr[k]*arr[j] + fn(i,k,arr,dp) + fn(k+1,j,arr,dp);
            if(steps<mini) mini =steps;
            // mini= Math.min(mini,steps);
        }
        
        return dp[i][j]= mini;
    }
    
    
    static int matrixMultiplication(int N, int arr[])
    {
        
        int dp[][] = new int[N][N];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
       return fn(1,N-1,arr,dp);
    }
}


//tabulation

class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        if (N <= 1) return 0;
        
        int dp[][] = new int[N][N];
        
        for (int i = 1; i < N; i++) dp[i][i] = 0;
        
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][N - 1];
    }
}
