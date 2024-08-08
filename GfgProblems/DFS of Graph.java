class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
         ArrayList<Integer> ls = new  ArrayList<>();
         boolean vis[] = new boolean[V+1];
         vis[0]=true;
         dfs(0,vis,adj,ls);
         return ls;
}
public void dfs(int node , boolean vis[] , ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> ls ){
    vis[node] = true;
    ls.add(node);
    
    
    for(Integer it : adj.get(node)){
        if(vis[it]==false){
            dfs(it,vis,adj,ls);
        }
    }
}

}