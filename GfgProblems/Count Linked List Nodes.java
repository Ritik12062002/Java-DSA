class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        
        Node temp =head;
        
        int len =0;
        
        while(temp != null){
            len++;
            temp =temp.next;
        }
        
        return len;
    }
}