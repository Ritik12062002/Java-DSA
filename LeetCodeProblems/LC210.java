class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        
        // Initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph and fill inDegrees
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph[pre].add(course);
            inDegree[course]++;
        }
        
        // Add all courses with no prerequisites (inDegree 0) to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process nodes with inDegree 0
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;
            
            for (int neighbor : graph[current]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we were able to order all courses, return the result
        if (index == numCourses) {
            return result;
        } else {
            return new int[0]; // Not possible to finish all courses
        }
    }
}