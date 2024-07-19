class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[] = new int[26];
        int n =s.length();

        for(int i=0;i<n;i++){

            last[s.charAt(i)-'a'] =i;
        }

        List<Integer> ans = new ArrayList<>();
        int LastParitionedEnd=0;
        int maxInd=0;

        for(int i=0;i<n;i++){
            maxInd=Math.max(maxInd,last[s.charAt(i)-'a']);
            if(i==maxInd){
                ans.add(i-LastParitionedEnd+1);
                LastParitionedEnd = i+1;
            }
        }
        return ans;
    }
}