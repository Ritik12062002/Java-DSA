class Solution {

    public void flatten(TreeNode root) {
     if(root==null) return ;

     flatten(root.left);
     flatten(root.right);

     TreeNode tempright = root.right;

     root.right = root.left;
     root.left=null;


     while(root.right!=null){
        root=root.right;
     }

     root.right =tempright;
    }
}