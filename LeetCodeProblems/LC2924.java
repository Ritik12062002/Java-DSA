class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int incoming[] =new int[n];

        for(int[] edge: edges){
            incoming[edge[1]]++;
        }

        int champ=-1;
        int cnt=0;

        for(int i=0;i<n;i++){

            if(incoming[i] ==0){
                cnt++;
                champ=i;
            }
        }

        return cnt>1 ? -1:champ;
    }
}