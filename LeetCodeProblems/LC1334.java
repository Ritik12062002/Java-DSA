class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       int m = edges.length;
       int[][] dis = new int[n][n];

       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            dis[i][j]=Integer.MAX_VALUE;
        }
       }

       for(int i=0;i<m;i++){
        int u =edges[i][0];
        int v =edges[i][1];
        int wt =edges[i][2];

        dis[u][v]=wt;
        dis[v][u]=wt;
       }

       for(int i=0;i<n;i++) dis[i][i]=0;

       for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
      
         if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE )  continue;

         dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);

        }
     }
 } 


 int cntCity =n;
 int cityNo=-1;

 for(int city=0;city<n;city++){
    int cnt=0;

    for(int adjCity=0; adjCity<n;adjCity++){
        if(dis[city][adjCity] <= distanceThreshold)
        cnt++;
    }

    if(cnt<=cntCity){
        cntCity=cnt;
        cityNo=city;
    }
 }
 return cityNo;

    }
}