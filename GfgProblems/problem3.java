
class MyQueue {

    int front, rear;
	int arr[] = new int[100005];
	int n;

    MyQueue()
	{
		front=0;
		rear=0;
		 n = arr.length;
	}
	public boolean isEmpty(){
	    return rear==front;
	}
	public boolean isFull(){
	    return ((rear+1) % n) == front;
	}
	void push(int x)
	{
	   if(isFull()) return;
	   
	   arr[rear]=x;
	   rear =(rear+1)%n;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		if(isEmpty()) return -1;
		
		int res =arr[front];
		
		front = (front+1) %n ;
		
		return res;
	} 
}

