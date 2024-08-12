class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    bfs(row, col, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(int row, int col, char[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        // Direction vectors for moving up, down, left, right
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = ro + delRow[i];
                int ncol = co + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}