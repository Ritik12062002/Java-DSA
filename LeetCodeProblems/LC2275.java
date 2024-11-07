class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        if (n == 0)
            return 0;

        int maxSize = 0;

        for (int bit = 0; bit < 24; bit++) {
            int cnt = 0;

            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    cnt++;
                }
            }

            maxSize = Math.max(maxSize,cnt);
        }

        return maxSize;
    }
}