class Solution {
    public String shortestPalindrome(String s) {
        int n =s.length();

         String rev = new StringBuilder(s).reverse().toString();
        

        for(int i=0;i<n;i++){
            if(s.substring(0,n-i).equals(rev.substring(i))){
                return rev.substring(0,i) + s;
            }
        }
          return rev+s;

    }
}


//Approach (Using LPS in KMP)



class Solution {
    public void computeLPS(String pat , int[] lps){
     int m =pat.length();
     int len=0;
     lps[0]=0;
     int i=1;
 
     while(i<m){
         if(pat.charAt(i)==pat.charAt(len)){
             len++;
             lps[i]=len;
             i++;
         }else{
             if(len!=0){
                 len=lps[len-1];
 
             }else{
                 lps[i]=0;
                 i++;
             }
         }
     }
 
    }
 
 
 
     public String shortestPalindrome(String s) {
         String rev = new StringBuilder(s).reverse().toString();
         String temp =s+"-"+rev;
         int[] LPS=new int[temp.length()];
         computeLPS(temp,LPS);
         int longestLPSlen=LPS[temp.length()-1];
 
         String c =rev.substring(0,s.length()-longestLPSlen);
         return c+s;
     }
 }