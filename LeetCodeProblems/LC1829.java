class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n =nums.length;
        if(n==0) return new int[0];

        int xor =0;

        for(int num:nums){
            xor ^=num;
        }

        int maxK = (1<<maximumBit) -1;

        int res[] =new int[n];

        for(int i=0;i<n;i++){

            res[i] =xor^maxK;

            xor ^= nums[n-i-1];
        }

        return res;


    }
}