package LinkedLists;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		for (Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");
	}

	public void addFirst(int val) {
		if (size() == 0) {
			this.addFirstElement(val);
			return;
		}
		// creation of node
		Node temp = new Node();
		temp.data = val;

		// linking with head
		temp.next = this.head;

		// updating properties
		this.head = temp;
		this.size++;
	}

	public void addLast(int val) {
		if (size() == 0) {
			this.addFirstElement(val);
			return;
		}
		// creation of node
		Node temp = new Node();
		temp.data = val;
		temp.next = null;

		// linking with tail
		this.tail.next = temp;

		// updating properties
		this.tail = temp;
		this.size++;
	}

	private void addFirstElement(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.next = null;

		this.head = temp;
		this.tail = temp;
		this.size++;
	}

	public void addAt(int val, int ind) {

		if (ind == 0) {
			this.addFirst(val);
		} else if (ind == size) {
			this.addLast(val);
		} else {
			// creation of node
			Node temp = new Node();
			temp.data = val;

			// linking with tail
			// int i = 0;
			// for (Node traveler = head; traveler != null; traveler =
			// traveler.next) {
			// if (i == ind) {
			// temp.next = traveler.next;
			// traveler.next = temp;
			// this.size++;
			// }
			// i++;
			// }

			// sir's method
			if (ind < 0 || ind > size) {
				System.out.println("Index out of bound");
				return;
			} else {
				Node ims = this.getNodeAt(ind - 1);
				temp.next = ims.next;
				ims.next = temp;
				this.size++;
			}
		}
	}

	public int getFirst() {
		if (this.size == 0) {
			System.out.print("No elements in LL");
			return -1;
		}
		int val = this.head.data;
		return val;
	}

	public int getLast() {
		if (this.size == 0) {
			System.out.print("No element in LL");
		}
		int val = this.tail.data;
		return val;
	}

	public int getAt(int ind) {
		if (ind < 0 || ind >= size) {
			System.out.println("Index out of bound ");
			return -1;
		}
		Node temp = this.getNodeAt(ind);
		return temp.data;
	}

	public Node getNodeAt(int ind) {
		if (ind < 0 || ind >= size) {
			System.out.print("Index out of bound ");
			return null;
		}
		Node temp = this.head;
		for (int i = 0; i < ind; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int removeFirst() {
		if (this.size == 0) {
			System.out.print("No element to remove");
			return -1;
		}
		if (this.size == 1) {
			return this.removeOnlyElement();
		}
		int val = this.head.data;
		this.head = this.head.next;
		this.size--;
		return val;
	}

	public int removeLast() {
		if (this.size == 0) {
			System.out.print("No element to remove");
			return -1;
		}
		if (this.size == 1) {
			return this.removeOnlyElement();
		}
		int val = this.tail.data;
		Node ims = this.getNodeAt(this.size - 2);
		ims.next = null;
		this.tail = ims;
		this.size--;
		return val;
	}

	private int removeOnlyElement() {
		int val = this.head.data;
		this.head.next = null;
		this.tail.next = null;
		this.size = 0;
		return val;
	}

	public int removeAt(int ind) {

		if (this.size == 0) {
			System.out.print("No element to remove");
			return -1;
		} else if (this.size == 1) {
			return this.removeOnlyElement();
		}

		if (ind == 0) {
			return this.removeFirst();
		} else if (ind == size - 1) {
			return this.removeLast();
		}

		if (ind < 0 || ind >= size) {
			System.out.println("Index out of bound");
			return -1;
		} else {
			Node ims = this.getNodeAt(ind - 1);
			int val = ims.next.data;
			ims.next = ims.next.next;
			this.size--;
			return val;
		}
	}

	public void reverseDataIteratively() {
		Node left = this.head;
		Node right = this.tail;
		int i = 0;
		while (i != this.size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;

			left = left.next;
			right = this.getNodeAt(size - i - 2);
			i++;
		}
	}

	public void reversePointerIteratively() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node ocnext = curr.next;

			curr.next = prev;
			prev = curr;
			curr = ocnext;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void displayReverse() {
		this.displayReverse(head);
	}

	private void displayReverse(Node curr) {
		while (curr == null) {
			return;
		}
		displayReverse(curr.next);
		System.out.print(curr.data + " -> ");
	}

	public void reversePointerRecursively() {
		this.reversePointerRecursively(this.head, this.head.next);
	}

	private void reversePointerRecursively(Node prev, Node curr) {
		if (curr == null) {
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
			this.tail.next = null;
			return;
		}
		Node ocnext = curr.next;
		curr.next = prev;
		reversePointerRecursively(curr, ocnext);
	}

	private class Heapmover {
		Node node;
	}

	public void reverseDataRecursively() {
		Heapmover left = new Heapmover();
		left.node = head;
		this.reverseDataRecursively(left, head, 0);
	}

	private void reverseDataRecursively(Heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursively(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}
	}

	public void fold() {
		Heapmover left = new Heapmover();
		left.node = head;
		this.fold(left, head, 0);
	}

	private void fold(Heapmover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(left, right.next, floor + 1);
		if (floor >= this.size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			left.node = left.node.next.next;
		}
		if (floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public boolean IsPalindrome() {
		Heapmover left = new Heapmover();
		left.node = head;
		if (this.IsPalindrome(left, head, 0)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean IsPalindrome(Heapmover left, Node right, int floor) {
		if (right == null) {
			return true;
		}
		boolean b = IsPalindrome(left, right.next, floor + 1);
		if (b == false) {
			return false;
		}
		if (floor >= size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			left.node = left.node.next.next;
		}
		return b;
	}

	public int mid() {
		return this.mid(head);
	}

	private int mid(Node node) {
		Node slow = node;
		Node fast = node;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	// public boolean kthFromLast(int k) {
	//
	// }
}
