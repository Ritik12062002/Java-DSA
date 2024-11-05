class Solution {
    Node constructDLL(int arr[]) {
       
       
       int n =arr.length;
       if(n ==0) return null;
       Node head = new Node(arr[0]);
       Node temp =head;
       
       
       for(int i=1;i<n;i++){
           Node newNode = new Node(arr[i]);
           temp.next =newNode;
           newNode.prev =temp;
           temp =newNode;
       }
       return head;
       
    }
}