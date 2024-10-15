class Solution {
    long floorSqrt(long n) {
       long ans =1;
       long low=0,high=n;
       
       while(low<=high){
           
           long mid =(low+high) /2;
           
           if((mid*mid) <= n){
               ans=mid;
               low=mid+1;
               
           }else{
               high=mid-1;
           }
       }
       
       return ans;
    }
}