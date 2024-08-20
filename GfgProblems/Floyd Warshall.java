class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        int INF = 1000000000; // A large value to represent infinity
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = INF;
                }
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][k] < INF && matrix[k][j] < INF) { // Prevent overflow
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == INF){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}