class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length <n-1) return -1;

        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] connection: connections){
            int u=connection[0];
            int v=connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int cnt=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt-1;
    }


    public void dfs(int node , List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;

        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                dfs(adjNode,adj,vis);
            }
        }
    }
}