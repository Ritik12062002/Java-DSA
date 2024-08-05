class Solution
{
    private int count =0, ans=0;
    public int kthLargest(Node root,int K)
    {
        inorder(root,K);
        return ans;
    }
    
    private void inorder(Node root , int K){
        if(root==null) return ;
        
        inorder(root.right,K);
        
        
        count++;
        
        if(count == K){
            ans=root.data;
            return;
        }
         inorder(root.left,K);
       
    }
}