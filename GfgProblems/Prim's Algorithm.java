class Pair {
    int node, distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(0, 0));
        int vis[] = new int[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i)[0];
                int edW = adj.get(node).get(i)[1];

                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edW));
                }
            }
        }
        return sum;
    }
}