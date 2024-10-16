class Solution {
    public int shipWithinDays(int[] weights, int days) {

         int maxi=Integer.MIN_VALUE;
         int sum=0;

         for(int i=0;i<weights.length;i++){
            maxi =Math.max(maxi,weights[i]);
            sum += weights[i];
         }


        int low = maxi, high =sum;

        while(low<=high){

            int mid=(low+high)/2;
            int noOfDays = findDays(weights,mid);

            if(noOfDays <= days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }


    public int findDays( int[] weights,int capacity){

        int days=1 ,load=0;
        int n =weights.length;

        for(int i=0;i<n;i++){

        if(load + weights[i] > capacity){
            days=days+1;
            load=weights[i];
        }
        else{
            load +=weights[i];

        }

        }

        return days;
    }
}