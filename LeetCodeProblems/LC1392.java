class Solution {
    public String longestPrefix(String s) {
        int[] pref = new int[s.length()];
        Arrays.fill(pref,-1);
        int i=1 , j=0 , max=-1;

        while(i<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                pref[i]=j;
                i++;
                j++;
            }
            else if(j>0){
                j= pref[j-1]+1;
            }else{
                i++;
            }
        }
        max=pref[s.length()-1];
        return s.substring(0,max+1);
    }
}