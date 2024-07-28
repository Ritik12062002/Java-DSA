class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

         if(root == null) {
            return result;
         }
         
         Queue<TreeNode> q= new LinkedList<>();
         q.add(root);
         boolean leftToRight = true;

         while(!q.isEmpty()){
            int size =q.size();
            Deque<Integer> currLevel = new LinkedList<>();
           
           for(int i=0;i<size;i++){
            TreeNode currNode =q.poll();

            if(leftToRight){
                currLevel.addLast(currNode.val);
            }else{
                currLevel.addFirst(currNode.val);

            }
            if(currNode.left !=null){
                q.add(currNode.left);
            }
             if(currNode.right !=null){
                q.add(currNode.right);
            }

           }
           result.add( new ArrayList<>(currLevel));
           leftToRight = !leftToRight;
 
    }
    return result;
}
}