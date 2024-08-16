class Pair {
    int f, s;
    Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; 
        }

        int[][] visited = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = 1;

        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCol = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.f, col = p.s;
            int dist = visited[row][col];

            if (row == n - 1 && col == n - 1) {
                return dist; 
            }

            for (int i = 0; i < 8; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && visited[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = dist + 1; 
                }
            }
        }

        return -1; 
    }
}
