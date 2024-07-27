class Solution {

    private int checkHeight(TreeNode node){
        if(node==null) return 0;

        int leftH= checkHeight(node.left);
        if(leftH==-1) return -1;
  
        int rightH= checkHeight(node.right);
        if(rightH==-1) return -1;


        if(Math.abs(leftH-rightH)>1) return -1;

        return Math.max(leftH,rightH)+1;

    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}