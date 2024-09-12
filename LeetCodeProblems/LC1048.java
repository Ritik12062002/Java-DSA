class Solution {
        

    public boolean checkPossible(String Str1, String Str2) {
        if (Str1.length() != Str2.length() + 1) return false;

        int first = 0;
        int second = 0;

        while (first < Str1.length()) {
            if (second < Str2.length() && Str1.charAt(first) == Str2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

      
        return first == Str1.length() && second == Str2.length();
    }
    public int longestStrChain(String[] words) {
        int n =words.length;
        if(n==0) return 0;
        Arrays.sort(words,(a,b) -> a.length() -b.length());

        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int lsc=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){

                if(checkPossible(words[i],words[j])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            lsc =Math.max(lsc,dp[i]);
        }

        return lsc;
    }
}