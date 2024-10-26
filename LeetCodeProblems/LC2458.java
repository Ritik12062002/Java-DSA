class Solution {
    int [] treeH ,treeHL, treeHR;

    private int calculateHeight(TreeNode root){
      if(root==null) return 0;

      int leftH=calculateHeight(root.left);
      int rightH=calculateHeight(root.right);

      treeHR[root.val] =rightH;
      treeHL[root.val] =leftH;

      return  1 + Math.max(leftH,rightH);

    }


    private void compuateMaxheight(TreeNode node ,int maxHeightSofar , int depth){
      if(node==null) return ;
      treeH[node.val]=maxHeightSofar;

      compuateMaxheight(node.left,Math.max(maxHeightSofar,depth + treeHR[node.val]),depth+1);
      compuateMaxheight(node.right,Math.max(maxHeightSofar,depth + treeHL[node.val]),depth+1);

  
    }


  public int[] treeQueries(TreeNode root, int[] queries) {
       treeH= new int[100001];
       treeHL= new int[100001]; 
       treeHR= new int[100001]; 

      calculateHeight(root);
      compuateMaxheight(root.left,treeHR[root.val],1);
      compuateMaxheight(root.right,treeHL[root.val],1);

      int n =queries.length;
      int res[] =new int[n];
      for(int i=0;i<n;i++){
       res[i]= treeH[queries[i]];
      }
      return res;
  
  }
}