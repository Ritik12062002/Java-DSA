class Solution {
    int cnt=0;
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return cnt;
    }

    public void mergesort(int nums[] , int left, int right){
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        countpairs(nums,left,mid,right);
        merge(nums,left,mid,right);
    }

    public void merge(int nums[], int left, int mid, int right){
        int ind1=left;
        int ind2=mid+1;

        ArrayList<Integer> temp = new ArrayList<>();

        while(ind1 <=mid && ind2 <=right){
            if(nums[ind1] <= nums[ind2]){
                temp.add(nums[ind1]);
                ind1++;
            }else{
                temp.add(nums[ind2]);
                ind2++;

            }
        }

        while(ind1 <= mid){
          temp.add(nums[ind1]);
           ind1++;
        
        }

        while(ind2 <= right){
            temp.add(nums[ind2]);
            ind2++;
        }

        for(int i=left;i<=right;i++){
            nums[i] = temp.get(i-left);
        }
    }

    public void countpairs(int nums[] , int low, int mid, int high){

        int right =mid+1;

        for(int i=low; i<=mid;i++){
            while(right<=high && (long)nums[i] > (long)2*(long)nums[right]){
                right++;
            }
            cnt += (right-(mid+1));
        }
    }
}