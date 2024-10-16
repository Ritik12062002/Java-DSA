public class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(nums, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int countPartitions(int[] nums, int maxSum) {
        int partition = 1;
        int subarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (subarray + nums[i] > maxSum) {
                partition++;
                subarray = nums[i];
            } else {
                subarray += nums[i];
            }
        }
        return partition;
    }

}