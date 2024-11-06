class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
       
       
       Node temp=head;
       
       int i=0;
       
       while(temp != null && i<p){
           temp=temp.next;
           i++;
       }
       
       if(temp != null){
           Node newNode =new Node(x);
           newNode.next=temp.next;
           newNode.prev=temp;
           
       
       
       if(temp.next != null){
           temp.next.prev =newNode;
       }
       
       
           temp.next =newNode;
      
       } 
       
       return head;
    }
}