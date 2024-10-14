
class Solution {
    int count(int[] arr, int n, int x) {
        int cnt[] = firstAndLastPosition(arr,n,x);
        
        if(cnt[0] ==-1) return 0;
        
        return (cnt[1] -cnt[0] +1);
        
    }
    
    public int[] firstAndLastPosition(int nums[] , int n , int x){
        
        int first =-1, last =-1;
        
        int low=0; int high=n-1;
        
        while(low <= high){
            int mid= (low+high)/2;
            
            
            if(nums[mid] == x){
                first =mid;
                high=mid-1;
            }else if(nums[mid] < x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        // Reset low and high for finding the last occurrence
        low = 0;
        high = n - 1;
        
         while(low <= high){
            int mid= (low+high)/2;
            
            
            if(nums[mid] == x){
                last =mid;
                low=mid+1;
            }else if(nums[mid] < x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return new int[]{first,last};
    }
}