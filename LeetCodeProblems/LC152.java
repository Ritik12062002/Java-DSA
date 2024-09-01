class Solution {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int maxP=nums[0],minP=nums[0],res=nums[0];

        for(int i=1;i<n;i++){
            int num =nums[i];

            if(num<0){
                int temp=maxP;
                maxP=minP;
                minP=temp;
            }
            maxP=Math.max(num,maxP*num);
            minP=Math.min(num,minP*num);
            res=Math.max(res,maxP);
        }
        return res;
    }
}