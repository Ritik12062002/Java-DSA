class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (ans.size() == 0 || (ans.size() == 1 && ans.get(0) != nums[i])) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) cnt++;
                }
                if (cnt > n / 3) {
                    ans.add(nums[i]);
                }
                if (ans.size() == 2) break;
            }
        }
        return ans;
    }
}
