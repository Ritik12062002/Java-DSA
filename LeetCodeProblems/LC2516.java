class Solution {
    public int takeCharacters(String s, int k) {
        
        int n =s.length();

        int cnt[] =new int[3];

        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }

        if(cnt[0] <k || cnt[1] <k || cnt[2] <k){
            return -1;
        }

        int reqA =cnt[0]-k, reqB =cnt[1]-k, reqC =cnt[2]-k;
        int maxL=0;
        int[] current =new int[3];
        int left=0;


        for(int right=0;right<n;right++){
            current[s.charAt(right) -'a']++;

            while(current[0] > reqA || current[1] > reqB ||  current[2] > reqC){
            current[s.charAt(left) -'a']--;
            left++;           
            }

            maxL=Math.max(maxL,right-left+1);
        }

        return n-maxL;
    }
}