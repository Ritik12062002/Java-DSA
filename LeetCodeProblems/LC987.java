class Solution {
    class Tuple{
     TreeNode node;
     int col ,row;

      Tuple(TreeNode node, int col, int row){
         this.node =node;
         this.col=col;
         this.row=row;
     }
    }

 public List<List<Integer>> verticalTraversal(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
     if(root==null){
          return result;
     }
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> q= new LinkedList<>();
    q.offer(new Tuple(root,0,0));

    while(!q.isEmpty()){
     Tuple tuple =q.poll();
     TreeNode node =tuple.node;
     int col =tuple.col;
     int row =tuple.row;

     map.putIfAbsent(col,new TreeMap<>());
     map.get(col).putIfAbsent(row,new PriorityQueue<Integer>());
     map.get(col).get(row).offer(node.val);

     if(node.left!=null){
         q.offer(new Tuple(node.left,col-1,row+1));
     }
     if(node.right!=null){
         q.offer(new Tuple(node.right,col+1,row+1));
     }

    }

    for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
     result.add(new ArrayList<>());

     for(PriorityQueue<Integer> nodes: ys.values()){
         while(!nodes.isEmpty()){
             result.get(result.size()-1).add(nodes.poll());
         }
     }
    }
    return result;
 }
}