//bfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int[] indegree = new int[numCourses];

        for(int[] prerequisite : prerequisites){
            int course =prerequisite[0];
            int pre =prerequisite[1];
            graph[pre].add(course);
            indegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            cnt++;
            for(int neighbor: graph[curr]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        return cnt==numCourses;
    }
}


//dfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Fill the graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph[pre].add(course);
        }
        
        // Arrays to keep track of visit status
        boolean[] visited = new boolean[numCourses];  
        boolean[] inStack = new boolean[numCourses];  
        
        // Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, inStack)) {
                    return false;  // If a cycle is detected, return false
                }
            }
        }
        
        return true;  // If no cycles are detected, all courses can be completed
    }
    
    private boolean dfs(int node, List<Integer>[] graph, boolean[] visited, boolean[] inStack) {
        // Mark the node as visited and part of the current recursion stack
        visited[node] = true;
        inStack[node] = true;
        
        // Check all adjacent nodes
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, inStack)) {
                    return true;  // Cycle detected
                }
            } else if (inStack[neighbor]) {
                return true;  // Cycle detected
            }
        }
        
        // Remove the node from the recursion stack
        inStack[node] = false;
        return false;
    }
}