
class Solution {
    public int rowWithMax1s(int arr[][]) {

        int n = arr.length;
        int m = arr[0].length;
        int cnt_max = 0;
        int ind = -1;

        for (int i = 0; i < n; i++) {

            int cnt_ones = m - lowerBound(arr[i], m, 1);

            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                ind = i;
            }
        }

        return ind;

    }

    private int lowerBound(int arr[], int n, int x) {

        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
}