class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        
        if(head == null ) return 0;
        Node slow=head;
        Node fast =head;
        int cnt=0;
        
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow == fast){
               
               Node temp =slow;
               
               do{
                   cnt++;
                   slow=slow.next;
               }while(slow != temp);
               return cnt;
            }
        }
        return 0;
    }
}