// Brute force

class Solution {
    public int characterReplacement(String s, int k) {
        int n =s.length();

        int maxLen=0;

        for(int i=0;i<n;i++){
            int count[] =new int[26];
            int maxCount=0;

            for(int j=i;j<n;j++){
                count[s.charAt(j) -'A']++;
                maxCount =Math.max(maxCount ,count[s.charAt(j)-'A']);

                int charsToReplace = (j-i+1 ) - maxCount;


                if(charsToReplace <=k){
                    maxLen =Math.max(maxLen, j-i+1);
                }else{
                    break;
                }
            }
        }

        return maxLen;
    }
}


// optimal using sliding window



class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l = 0, r = 0, maxLen = 0, maxCount = 0;
        int count[] = new int[26];

        while (r < n) {
            count[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxCount > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}