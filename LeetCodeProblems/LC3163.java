class Solution {
    public String compressedString(String word) {
        
        StringBuilder comp = new StringBuilder();
        int n =word.length();
        int i=0;

        while(i<n){

            char currentWord =word.charAt(i);
            int cnt =0;

            while(i<n && word.charAt(i) == currentWord && cnt <9){
                cnt++;
                i++;
            }

            comp.append(cnt).append(currentWord);
        } 

        return comp.toString();
    }
}