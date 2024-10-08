class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        int myHeight = Math.max(leftHeight,rightHeight)+1;

        return myHeight;
    }
}