class Solution {
    public String minWindow(String s, String t) {
       int m =s.length();
       int n =t.length();

       int[] hashArr = new int[128];
       for(int i=0;i<n;i++){
        hashArr[t.charAt(i)]++;
       }      

       int l=0,r=0,cnt=0,sIndex=-1;
       int minLen =Integer.MAX_VALUE;

       while(r<m){
        char rightChar =s.charAt(r);
        if(hashArr[rightChar] >0){
            cnt++;
        }

        hashArr[rightChar]--;

        while(cnt == n){
            if(r-l+1 < minLen){
                minLen =r-l+1;
                sIndex=l;
            }

            char leftChar =s.charAt(l);
            hashArr[leftChar]++;
            if(hashArr[leftChar] >0){
                cnt--;
            }
            l++;
        }
        r++;
       }

       return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}