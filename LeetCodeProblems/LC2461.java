class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long maxSum = 0, currentSum = 0;
        Set<Integer> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
           
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

           
            set.add(nums[right]);
            currentSum += nums[right];

           
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

              
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
