package classesObjects;

public class Stack {
	private int[] data;
	private int tos = -1;
	
	public Stack(int capacity){
		data = new int[capacity];
	}
	public Stack(){
		this(5);
	}
	public int top(){
		if(this.tos==-1){
			System.out.println("stack underflow");
			return -1;
		}
		int value = this.data[this.tos];
		return value;
	}
	// check for overflow
	public void push(int val){
		if(this.tos==data.length-1){
			System.out.println("stack overflow");
			return;
		}
		this.tos++;
		this.data[this.tos] = val;
	}
	// check for underflow
	public int pop(){
		if(this.tos==-1){
			System.out.print("Stack underflow");
			return -1;
		}
		int value = this.data[this.tos];
		this.data[tos] = 0;
		this.tos--;
		return value;
	}
	public int size(){
		return this.tos+1;
	}
	public boolean isEmpty(){
		if(this.size()==0){
			return true;
		}
		else return false;
	}
	public void display(){
		System.out.println("--------------------");
		for(int i=tos; i>=0; i--){
			System.out.print(this.data[i]+" ");
		}
		System.out.println(".");
		System.out.println("----------------------");
	}
}
