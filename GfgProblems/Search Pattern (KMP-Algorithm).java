class Solution
{
    
    private int[] computeLPS(String p){
        int M=p.length();
        int[] lps=new int[M];
        int len=0, i=1;
        lps[0]=0;
        
        while(i<M){
            if(p.charAt(i)==p.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len !=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    
    
    
    ArrayList<Integer> search(String pat, String txt)
    {
         ArrayList<Integer> res = new  ArrayList<>();
         int n =txt.length();
         int m =pat.length();
         int[] lps = computeLPS(pat);
         int j=0,i=0;
         
         while(i<n){
             if(j<m && pat.charAt(j) == txt.charAt(i)){
                 i++;
                 j++;
             }
             if(j==m){
                 res.add(i-j+1);
                 j=lps[j-1];
             }else if(i<n && (j==0 || pat.charAt(j) != txt.charAt(i))){
                 if(j!=0){
                     j=lps[j-1];
                 }else{
                     i++;
                 }
             }
         }
         return res;
    }
}