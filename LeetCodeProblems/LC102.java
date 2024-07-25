class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> currLevel =new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode currVal =q.remove();
                currLevel.add(currVal.val);

                if(currVal.left != null){
                    q.add(currVal.left);
                }
                if(currVal.right != null){
                    q.add(currVal.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}