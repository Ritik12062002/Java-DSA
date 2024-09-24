class Solution {
    public int findMatching(String text, String pat) {
        int n = text.length();
        int m =pat.length();
        if(n<m) return -1;
        
        for(int i=0;i<=n-m;i++){
            int j=0;
            
            while(j<m && text.charAt(i+j)== pat.charAt(j)){
                j++;
            }
            
            if(j==m) return i;
        }
        
        return -1;
    }
}
