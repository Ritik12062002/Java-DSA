class Solution {
    public int NthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = fn(mid, n, m);

            if (result == 1) return mid;
            else if (result < 1) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static int fn(int mid, int n, int m) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= mid;

            if (ans > m) return 2;  // Exceeded m, return 2 to reduce the search space
        }

        if (ans == m) return 1;  // Found exact match
        return 0;  // Less than m, increase the search space
    }
}
