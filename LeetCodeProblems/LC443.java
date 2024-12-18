class Solution {
    public int compress(char[] chars) {
        
        int n =chars.length;
        int i=0;
        int index =0;

        while(i<n){
            char currentWord = chars[i];
            int cnt =0;

            while(i<n && chars[i] == currentWord){
                cnt++;
                i++;
            }


            chars[index++] =currentWord;

            if(cnt >1){
                for(char c: String.valueOf(cnt).toCharArray()){
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}