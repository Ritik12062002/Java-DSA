class Solution {
    public DLLNode reverseDLL(DLLNode head) {
       if(head == null) return null;
       
       DLLNode temp =null;
       DLLNode current =head;
       
       while(current != null){
           
           temp =current.prev;
           current.prev=current.next;
           current.next =temp;
           current=current.prev;
       }
       
       if(temp !=null){
           head =temp.prev;
       }
       return head;
       
    }
}