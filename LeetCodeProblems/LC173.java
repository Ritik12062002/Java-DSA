class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
     public BSTIterator(TreeNode root) {
         pushAll(root);
     }
     
     public int next() {
         TreeNode tempnode =st.pop();
         pushAll(tempnode.right);
         return tempnode.val;
     }
     
     public boolean hasNext() {
         return !st.isEmpty();
     }
 
 
     private void pushAll(TreeNode node){
         for(;node!=null;st.push(node),node=node.left);
     }
 }