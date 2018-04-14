package lecture_2;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution l = new Solution();
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int i=1;
        while(i<=n){
            int data = sc.nextInt();
            if(i==1){
                l.addFirstElement(data);
            } else {
                l.addLast(data);
            }
            i++;
        }
        l.reverseByK(k);
        l.display();
    }
    class Node{
    int data;
    Node next;
    }
    private Node head=null;
	private Node tail=null;
	private int size=0;
    
    Solution(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }
    public void addFirst(int val){
        if(size()==0){
            this.addFirstElement(val);
            return;
        }
        Node temp = new Node();
        temp.data = val;
        temp.next = this.head;
        this.head = temp;
        this.size++;
    }
    public void addFirstElement(int val){
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        
        this.head = temp;
        this.tail = temp;
        this.size++;
    }
    public void addLast(int val){
        if(size()==0){
            this.addFirstElement(val);
            return;
        }
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        
        this.tail.next = temp;
        this.tail = temp;
        this.size++;
    }
    public void addAt(int val, int index){
        if(index<0 || index>size){
            return;
        }
        if(size()==0){
            this.addFirstElement(val);
        }
        if(index==1){
            this.addFirst(val);
        } else if(index==size){
            this.addLast(val);
        }
        Node temp = new Node();
        temp.data = val;
        Node curr = this.getNodeAt(index-1);
        temp.next = curr.next;
        curr.next = temp;
        this.size++;
    }
    public Node getNodeAt(int in){
        if(in<0 || in>size){
            return null;
        }  
        Node temp = this.head;
        for(int i=0;i<in;i++){
            temp = temp.next;
        }
        return temp;
    }
    public void display(){
        this.display(head);
    }
    private void display(Node temp){
        if(temp==null){
            return;
        }
        System.out.print(temp.data+" ");
        display(temp.next);
    }
    
    private class Heapmover{
        Node node;
    }
    
    public void reverseByK(int k){
        Heapmover left = new Heapmover();
        left.node = this.head;
        Node temp = this.head;
        this.reverseByK(left,head,k,k,0,temp);
    }
    
    private void reverseByK(Heapmover left, Node right, int k, int i,int floor, Node temp){
        if(right==null){
        	return;
        }
    	if(i==0){
            return;
        }
        reverseByK(left,right.next,k,i--,floor+1,temp);
        if((floor%k)>=k/2){
            temp = right.next;
            int val = right.data;
            right.data = left.node.data;
            left.node.data = val;
            left.node = left.node.next;
            i=k;
        } else {
        	int val = right.data;
            right.data = left.node.data;
            left.node.data = val;
        }
        if(temp!=null){
            right = temp;
            left.node = temp;
            reverseByK(left,right,k,k,0,temp);
        }
    }
}