class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);  // Step 1: Sort the array for two-pointer search

        int n = nums.length;
        long cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;

            // Find the smallest index where nums[i] + nums[left] >= lower
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] + nums[mid] >= lower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int minJ = left;

            left = i + 1;
            right = n - 1;

            // Find the largest index where nums[i] + nums[right] <= upper
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] + nums[mid] <= upper) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int maxJ = right;

            // Count valid pairs (i, j) where minJ <= j <= maxJ
            if (minJ <= maxJ) {
                cnt += maxJ - minJ + 1;
            }
        }
        return cnt;
    }
}