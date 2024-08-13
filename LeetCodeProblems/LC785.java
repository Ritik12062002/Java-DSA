class Solution {
    public boolean isBipartite(int[][] graph) {
        int n =graph.length;
        int color[] = new int[n];

        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!dfs(i,1,graph,color)) return false;
            }
        }
        return true;
    }

            
    private boolean dfs(int node,int c ,int[][] graph , int[] color){
          color[node] =c;

          for(int negibhor : graph[node]){
            if(color[negibhor]==0){
                if(!dfs(negibhor,-c,graph,color)) return false;
            }else if(color[negibhor]==color[node]) return false;
          }
          return true;
}
}