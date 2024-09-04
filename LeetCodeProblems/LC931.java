// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int minSum = Integer.MAX_VALUE;

//         // Iterate over each element in the last row
//         for (int j = 0; j < n; j++) {
//             minSum = Math.min(minSum, fn(n - 1, j, matrix));
//         }

//         return minSum;
//     }

//     public int fn(int i, int j, int[][] matrix) {
//         // Boundary condition to check if the column is out of bounds
//         if (j < 0 || j >= matrix.length) return Integer.MAX_VALUE;
//         // Base case: when we are in the first row
//         if (i == 0) return matrix[0][j];

//         // Calculate the minimum path sum
//         int s = matrix[i][j] + fn(i - 1, j, matrix);         // Straight down
//         int ld = matrix[i][j] + fn(i - 1, j - 1, matrix);    // Left diagonal
//         int rd = matrix[i][j] + fn(i - 1, j + 1, matrix);    // Right diagonal

//         return Math.min(s, Math.min(ld, rd));
//     }
// }

class Solution {
    public int minFallingPathSum(int[][] matrix) {
     int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the minimum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9); // Use a large positive number for out of bounds
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9); 
                }

                // Store the minimum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }
}