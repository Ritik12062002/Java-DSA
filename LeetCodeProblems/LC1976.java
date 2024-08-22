class Solution {
    public int countPaths(int n, int[][] roads) {
        // Define a mod value as the result can be very large
        int MOD = 1_000_000_007;

        // Create a graph as an adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the adjacency list
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Min-heap to implement Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0}); // {node, distance from source}
        
        // Distance array to store the shortest path to each node
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Ways array to store the number of ways to reach each node with the shortest path
        int[] ways = new int[n];
        ways[0] = 1;
        
        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            long d = curr[1];
            
            if (d > dist[u]) continue;
            
            // Traverse all neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                long time = neighbor[1];
                
                if (dist[v] > dist[u] + time) {
                    dist[v] = dist[u] + time;
                    pq.add(new int[]{v, (int) dist[v]});
                    ways[v] = ways[u];
                } else if (dist[v] == dist[u] + time) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}