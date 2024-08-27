class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, stones, vis);
            }
        }

        return n - cnt;
    }

    public void dfs(int i, int[][] stones, boolean[] vis) {
        vis[i] = true;
        int n = stones.length;

        for (int j = 0; j < n; j++) {
            if (!vis[j] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                dfs(j, stones, vis);
            }
        }
    }
}
