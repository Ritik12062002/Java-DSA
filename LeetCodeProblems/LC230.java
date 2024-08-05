class Solution {
    private int count=0 , result =0;
    public int kthSmallest(TreeNode root, int k) {
        inordertraversal(root,k);
        return result;
    }

    private void inordertraversal(TreeNode root, int k){
        if(root==null) return;

        inordertraversal(root.left,k);
        count++;
        if(count==k){
        result =  root.val;
            return;
        }
        inordertraversal(root.right,k);


    }
}