class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n= heights.length;
        int maxA=0;

        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width=0;
                if(st.isEmpty())   width =i;
                else  width =i-st.peek()-1;
               maxA =Math.max(maxA,height*width);
            }
            st.push(i);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int n =matrix.length;
        int m =matrix[0].length;

        int maxArea =0;
        int[] height=new int[m];
        Arrays.fill(height,0);

        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){

            if(matrix[i][j]=='1')  height[j]++;
            else height[j]=0;
        }
        int area =largestRectangleArea(height);
        maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
}