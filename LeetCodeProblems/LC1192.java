class Solution {
    private int timer = 1;

    public void dfs(int node, int parent, int[] vis, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) { // If `it` is not visited
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                // Check if the edge is a bridge
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            } else {
                // If `it` is visited, update the low value
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // Start DFS from all nodes (for disconnected graphs)
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tin, low, bridges);
            }
        }

        return bridges;
    }
}