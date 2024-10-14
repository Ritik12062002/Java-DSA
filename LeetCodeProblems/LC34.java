class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int f = firstOccuernce(nums,n,target);
        int l=  lastOccuernce(nums,n,target);

         return new int[]{f,l};
    }

    public int firstOccuernce(int[] nums,int n, int target){
        int low =0, high =n-1, first=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(nums[mid] == target){
                first=mid;
                high=mid-1;
            }else if(nums[mid] <target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return first;
    }
       public int lastOccuernce(int[] nums,int n, int target){
        int low =0, high =n-1, last=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(nums[mid] == target){
                last=mid;
                low=mid+1;
            }else if(nums[mid] <target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return last;
    }
}