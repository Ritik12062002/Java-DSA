class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> levelNodes = new LinkedList<>();

        root.val =0;
        levelNodes.add(root);

        while(!levelNodes.isEmpty()){
            int size =levelNodes.size();
            int sum =0;

            for(int i=0;i<size;i++){
                TreeNode currNode = levelNodes.remove();
                if(currNode.left !=null){
                    sum += currNode.left.val;
                }
                 if(currNode.right !=null){
                    sum += currNode.right.val;
                }
             levelNodes.add(currNode);
            }


            for(int i=0;i<size;i++){

                TreeNode node = levelNodes.remove();
                int newSum =sum;

                if(node.left !=null){
                    newSum -= node.left.val;
                    levelNodes.add(node.left);
                }
                 if(node.right !=null){
                    newSum -= node.right.val;
                    levelNodes.add(node.right);
                }

                if(node.left !=null){
                    node.left.val =newSum;
                }
                if(node.right !=null){
                    node.right.val =newSum;
                }
            }
        }
          return root;
    }
}