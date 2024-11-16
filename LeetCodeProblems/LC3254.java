class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxElement = nums[i];

            // Check if the subarray nums[i..i + k - 1] is consecutive
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] != nums[j - 1] + 1) {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j]);
            }

            // Add the result for this subarray
            res[i] = isConsecutive ? maxElement : -1;
        }

        return res;
    }
}
