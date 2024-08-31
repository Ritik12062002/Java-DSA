class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        // leave last house index =(0 to n-2)
        int max1=roblinear(nums,0,n-2);


         // leave first house index =(1 to n-1)
        int max2=roblinear(nums,1,n-1);

        return Math.max(max1,max2);
    }

    public int roblinear(int[] nums,int start,int end){
        int p1=0;
        int p2=0;
        for(int i=start;i<=end;i++){
            int curr =Math.max(p1,nums[i]+p2);
            p2=p1;
            p1=curr;
        }
        return p1;
    }
}