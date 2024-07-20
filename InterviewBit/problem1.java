public class Solution {
    public int[] prevSmaller(int[] A) {
        
        int n =A.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>= A[i]){
                st.pop();
                
            }
            if(!st.isEmpty()){
                res[i]=st.peek();
            }else{
                res[i]=-1;
            }
            
            st.push(A[i]);
        }
        return res;
    }
}
