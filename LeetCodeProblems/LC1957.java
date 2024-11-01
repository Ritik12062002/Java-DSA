class Solution {
    public String makeFancyString(String s) {
        
        int n =s.length();

        StringBuilder res = new StringBuilder();


        for(int i=0;i<n;i++){

            int len =res.length();


            if(len >=2 && res.charAt(len-1) == s.charAt(i) && res.charAt(len-2) == s.charAt(i)){
                continue;
            }

            res.append(s.charAt(i));
        }


        return res.toString();
    }
}