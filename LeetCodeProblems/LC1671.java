class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Not enough elements for a mountain array

        // Step 1: Calculate LIS for each position
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Calculate LDS for each position
        int[] lds = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Calculate minimum removals
        int minRemovals = n; // start with the worst case
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Ensure we have a peak
                int elementsToKeep = lis[i] + lds[i] - 1;
                minRemovals = Math.min(minRemovals, n - elementsToKeep);
            }
        }

        return minRemovals;
    }
}


