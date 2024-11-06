class Solution {
    public boolean canSortArray(int[] nums) {
        int n=nums.length;
        if(n==0) return false;
        
        for(int i=0;i<n-1;i++){
   
        if(nums[i] > nums[i+1] && Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])){
            int temp =nums[i];
            nums[i]=nums[i+1];
            nums[i+1] =temp;

      // Move back one step to re-check after the swap
            i=Math.max(-1,i-2);
        }
      }
        return checkArrIsSorted(nums);
    }

        public boolean checkArrIsSorted(int arr[]){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i] > arr[i+1])
                return false;
            }
            return true;
        }
    
}