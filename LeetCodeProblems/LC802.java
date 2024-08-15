class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();

        int indegree[]= new int[n];


        for(int i=0;i<n;i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int negibhor :graph[i]){
                adjRev.get(negibhor).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
         List<Integer> safeNodes = new ArrayList<>();


         for(int i=0;i<n;i++){
            if(indegree[i]==0){
               q.add(i);
            }
         }


         while(!q.isEmpty()){
            int node =q.poll();
              safeNodes.add(node);


              for(int negibhor : adjRev.get(node)){
                indegree[negibhor]--;
                if(indegree[negibhor]==0){
                    q.add(negibhor);
                }
              }
         }
         Collections.sort(safeNodes);
         return safeNodes;
    }
}