class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int l = 0, r = 0, cnt = 0, countodd = 0, res = 0;

        while (r < n) {
            if (nums[r] % 2 != 0) {
                countodd++;
                cnt = 0;
            }

            while (countodd == k) {
                if (nums[l] % 2 != 0) {
                    countodd--;
                }
                l++;
                cnt++;
            }

            res += cnt;

            r++;
        }

        return res;
    }
}