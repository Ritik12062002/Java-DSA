class Solution {
    int median(int matrix[][], int R, int C) {
      
        int low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            // Count elements smaller than or equal to mid in each row
            for (int i = 0; i < R; i++) {
                cnt += countSmallerThanMid(matrix[i], mid, C);
            }

            // Median position is (R * C) / 2 + 1 (1-based indexing)
            if (cnt < (R * C) / 2 + 1) {
                low = mid + 1; // Need more elements, search in the upper half
            } else {
                high = mid - 1; // Search in the lower half
            }
        }
        return low;
    }

    private int countSmallerThanMid(int arr[], int mid, int n) {
        // Binary search to find the number of elements <= mid in a row
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) / 2;

            if (arr[md] <= mid) {
                l = md + 1; 
            } else {
                h = md - 1; 
            }
        }
        return l; 
    }
}
