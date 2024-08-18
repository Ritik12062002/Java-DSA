class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

       
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});

        // Array to store the shortest time to each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Set to keep track of visited nodes
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (visited[node]) continue;
            visited[node] = true;

            // Check each neighbor of the current node
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int newTime = time + neighbor[1];
                    if (newTime < dist[nextNode]) {
                        dist[nextNode] = newTime;
                        pq.add(new int[]{nextNode, newTime});
                    }
                }
            }
        }

        // Find the maximum time from the dist array
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
