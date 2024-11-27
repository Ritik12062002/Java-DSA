class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<n-1;i++) graph.get(i).add(i+1);

        int res[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            graph.get(queries[i][0]).add(queries[i][1]);
            res[i] =bfs(graph,n);
        }

        return res;

    }

    private int bfs(List<List<Integer>> graph, int n ){
        Queue<int[]> q =new LinkedList<>();
        boolean[] visited =new boolean[n];

        q.add(new int[]{0,0});
        while(!q.isEmpty()){

            int curr[] = q.poll();
            if(curr[0] == n-1) return curr[1];

            for(int neigbhor : graph.get(curr[0])){
               if(!visited[neigbhor]){
                visited[neigbhor] =true;
                q.add(new int[]{neigbhor,curr[1]+1});
               }
            }
        }

        return -1;
    }
}