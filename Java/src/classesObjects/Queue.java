package classesObjects;

public class Queue {
	private int[] data;
	private int size;
	private int front;
	
	public Queue(int capacity){
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}
	
	public Queue(){
		this(5);
	}
	public void enqueue(int val){
		if(this.size==this.data.length){
			System.out.println("overflow");
			return;
		}
		int tail = (this.front+this.size)%this.data.length;
		this.data[tail] = val;
		this.size++;
	}
	public int dequeue(){
		if(this.size==0){
			System.out.println("underflow");
			return -1;
		}
		int val = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front+1)%this.data.length;
		this.size--;
		return val;
	}
	public int size(){
		return this.size;
	}
	public boolean isEmpty(){
		if(this.size()==0){
			return true;
		}
		else return false;
	}
	public int front(){
		if(this.size()==0){
			System.out.println("underflow");
			return -1;
		}
		int val = this.data[this.front];
		return val;
	}
	public void display(){
//		if(this.size()==0){
//			System.out.print("No element in queue");
//			return;
//		}
//		int ptr = this.front;
//		while(ptr<this.front+this.size()){
//			if(ptr==this.data.length){
//				ptr = 0;
//			}
//		    System.out.print(this.data[ptr]+" ");
//			System.out.println();
//			ptr++;
//		}
		// sir's method
		for(int i=0; i<this.size(); i++){
			int j = (front+i)%this.data.length;
			System.out.print(this.data[j]+" ");
		}
		System.out.println();
	}
}
