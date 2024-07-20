class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> ng = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int num:nums2){
            while(!st.isEmpty() && st.peek()< num){
                ng.put(st.pop(),num);
            }
            st.push(num);
        }
        while(!st.isEmpty()){
            ng.put(st.pop(),-1);
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]= ng.get(nums1[i]);
        }
        return result;
    }
}