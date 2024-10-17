class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0, col = m - 1; // Start from the top-right corner

        while (row < n && col >= 0) {

            if (matrix[row][col] == target) return true;

            else if (matrix[row][col] < target) row++;  // Move down if target is greater

            else col--;  // Move left if target is smaller
        }

        return false;
    }
}
