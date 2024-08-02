class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;

         return bstFromPreorder(preorder,0,preorder.length-1);
    }

    private TreeNode bstFromPreorder(int[] preorder ,int preStart ,int preEnd){

         if(preStart>preEnd) return null;
        
        
      TreeNode root = new TreeNode(preorder[preStart]);
      int i;

      for( i= preStart+1 ;i<=preEnd ;i++){
       if( preorder[i] > preorder[preStart])
        break;
      }


      root.left = bstFromPreorder(preorder,preStart+1 ,i-1);
      root.right = bstFromPreorder(preorder,i ,preEnd);

      return root;

        
    }
}