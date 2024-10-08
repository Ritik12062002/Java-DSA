
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }

    private int func(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        while (r < n) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);

            while (hm.size() > k) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if (hm.get(nums[l]) == 0) {
                    hm.remove(nums[l]);
                }
                l++;
            }

            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }
}