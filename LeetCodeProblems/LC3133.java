class Solution {
    public long minEnd(int n, int x) {
        
        long num = (long)x;

        for(int i=1;i<n;i++){
            
            num =(num+1)|x;
        } 
        return num;
    }
}