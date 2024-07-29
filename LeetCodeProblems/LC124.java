class Solution {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }

        
    private int maxPathDown(TreeNode root , int maxValue[]){
        if(root==null) return  0;

        int l= Math.max(0,maxPathDown(root.left,maxValue));
        int r= Math.max(0,maxPathDown(root.right,maxValue));

        maxValue[0]= Math.max(maxValue[0],l+r+root.val);
        return Math.max(l,r)+ root.val;

    }
}