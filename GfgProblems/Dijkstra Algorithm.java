class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[]=  new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S]=0;
        
        PriorityQueue<int[]> pq = new  PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{S,0});
        
        while(!pq.isEmpty()){
            int current[] =pq.poll();
            int u=current[0];
            int d=current[1];
            
            if(d>dist[u]) continue;
            
            for(ArrayList<Integer> edge :adj.get(u)){
                int v =edge.get(0);
                int weight =edge.get(1);
                if(dist[u]+weight < dist[v]){
                    dist[v]= dist[u]+weight ;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        
        return dist;
}
}