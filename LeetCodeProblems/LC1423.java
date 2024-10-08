class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum=0;

        for(int i=0;i<k;i++){
            totalSum += cardPoints[i];
        }

        int res= totalSum;

        for(int i=0;i<k;i++){

            // replace leftmost card with rightmost

          totalSum = totalSum - cardPoints[k-1-i] + cardPoints[n-1-i];
          res= Math.max(res,totalSum);
        }

        return res;
    }
}