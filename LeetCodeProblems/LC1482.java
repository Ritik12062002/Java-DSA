class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE, high = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] arr, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }
}
