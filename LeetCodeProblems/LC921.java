class Solution {
    public int minAddToMakeValid(String s) {
        int n =s.length();
        int cnt=0;
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char c= s.charAt(i);

            if(c=='('){
                st.push(c);
            }
            else if( c==')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else{
                    cnt++;
                }
            }
        }
        cnt += st.size();

        return cnt;
    }
}