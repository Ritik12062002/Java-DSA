class MyQueue {

    Stack<Integer> ip;
       Stack<Integer> op;

    public MyQueue() {
        ip = new Stack<>();
        op = new Stack<>();
    }
    
    public void push(int x) {
        ip.push(x);
    }
    
    public int pop() {
        if(op.isEmpty()){
            while(!ip.isEmpty()){
                op.push(ip.pop());
            }
        }
        return op.pop();
    }
    
    public int peek() {
         if(op.isEmpty()){
            while(!ip.isEmpty()){
                op.push(ip.pop());
            }
        }
        return op.peek();
    }
    
    public boolean empty() {
        return ip.isEmpty() && op.isEmpty();
    }
}
