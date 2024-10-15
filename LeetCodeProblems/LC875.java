class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while (low <= high) {
            int mid = (low + high) / 2;

            int totalH = calculateHours(piles, mid);

            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int findMax(int arr[]) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    public int calculateHours(int arr[], int speed) {
        int totalH = 0;
        for (int i = 0; i < arr.length; i++) {
            totalH += Math.ceil((double) arr[i] / speed);
        }
        return totalH;
    }
}
