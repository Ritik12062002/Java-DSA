class Solution
{
    //Function to return list containing vertices in Topological order. 
   public  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        
        int ans[]= new int[V];
        int i=0;
        
        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }
    
    
    public  static void dfs(int node , ArrayList<ArrayList<Integer>> adj,  int[] vis,  Stack<Integer> st){
        vis[node]=1;
        
        for(int it: adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis,st);
            }
        }
        st.push(node);
    }
}