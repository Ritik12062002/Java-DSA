class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root==null) return -1;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        List<Long> levelSums = new ArrayList<>();

        while(!q.isEmpty()){
            int size =q.size();
            long currentLevelSum =0;

            for(int i=0;i<size;i++){

                TreeNode currNode =q.remove();
                currentLevelSum += currNode.val;

                if(currNode.left != null){
                    q.add(currNode.left);
                }
                 if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
                levelSums.add(currentLevelSum);

        }

        levelSums.sort(Collections.reverseOrder());

        if(k>levelSums.size()) return -1;

        return levelSums.get(k-1);
    }
}