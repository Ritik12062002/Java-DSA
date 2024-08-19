class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        
        // Initialize distances from source to all other vertices as infinite
        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        
        // Relax all edges V-1 times
        for(int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // Check for negative-weight cycles
        for(ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp; // If a negative cycle is detected, return -1
            }
        }
        
        return dist; // Return the final distances
    }
}
