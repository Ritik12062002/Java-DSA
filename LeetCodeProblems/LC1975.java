class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long maxSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                maxSum += Math.abs(value);

                if (value < 0) {
                    negativeCount++;
                }

                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 == 0) {
            return maxSum;
        }

        return maxSum - 2*minAbsValue;
    }
}
