class Pair {
    int row, col, obstacles;

    Pair(int row, int col, int obstacles) {
        this.row = row;
        this.col = col;
        this.obstacles = obstacles;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns

        // Directions for movement: up, right, down, left
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1};

        // Deque for 0-1 BFS
        Deque<Pair> dq = new LinkedList<>();
        dq.add(new Pair(0, 0, 0)); // Start from the top-left corner with 0 obstacles removed

        // Visited array to avoid revisiting cells
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            Pair current = dq.poll(); // Process the current cell
            int row = current.row;
            int col = current.col;
            int obstacles = current.obstacles;

            // If we've reached the bottom-right corner, return the result
            if (row == m - 1 && col == n - 1) return obstacles;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i]; // Calculate the new row
                int ncol = col + dc[i]; // Calculate the new column

                // Check bounds and if the cell is already visited
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true; // Mark as visited

                    // Prioritize empty cells (add to the front)
                    if (grid[nrow][ncol] == 0) {
                        dq.addFirst(new Pair(nrow, ncol, obstacles));
                    } 
                    // Process obstacle cells (add to the back)
                    else {
                        dq.addLast(new Pair(nrow, ncol, obstacles + 1));
                    }
                }
            }
        }

        return 0; // Default return if no path is found (should not happen for valid inputs)
    }
}
