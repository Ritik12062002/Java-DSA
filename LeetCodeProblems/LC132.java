// recusion
// class Solution {

//     public boolean isPalindrome(int i,int j,String s){
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }

//    public int fn(int i, int n, String s){
//     if(i==n) return 0;
//     int minCost=Integer.MAX_VALUE;

//     for(int j=i;j<n;j++){
//         if(isPalindrome(i,j,s)){
//             int cost = 1 + fn(j+1,n,s);
//             minCost=Math.min(minCost,cost);
//         }
//     }

//     return minCost;
//    }



//     public int minCut(String s) {
//         int n =s.length();
//         return fn(0,n,s) -1;
//     }
// }


  //    dp
  



class Solution {

    public boolean isPalindrome(int i, int j, String s){
         while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

     public int minCut(String s) {
     int n =s.length();
     int dp[] = new int[n+1];
     Arrays.fill(dp,0);

     for(int i=n-1;i>=0;i--){
        int minCost=Integer.MAX_VALUE;

        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,s)){
            int cost= 1 + dp[j+1];
            minCost= Math.min(minCost,cost);
        }
        }

        dp[i]=minCost;
     }

     return dp[0]-1;
     }
}