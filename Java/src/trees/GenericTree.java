package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.soap.Node;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size;

	public GenericTree() {
		this.root = takeinput(new Scanner(System.in), null, -1);
	}

	private Node takeinput(Scanner scn, Node parent, int ci) {
		// take the input
		if (parent == null) {
			System.out.println("Enter the data for parent");
		} else {
			System.out.println("Enter the data for" + ci + parent.data);
		}

		// enter the data
		int data = scn.nextInt();

		// give it to child
		Node child = new Node();
		child.data = data;
		this.size++;
		// Enter the no of grandchildren
		int numgc = scn.nextInt();

		for (int i = 0; i < numgc; i++) {
			Node gc = takeinput(scn, child, i);
			child.children.add(gc);
		}

		return child;

	}

	public int size() {
		return this.size;

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + "->";
		for (Node ch : node.children) {
			str += ch.data + ",";
		}
		str += ".";
		System.out.println(str);
		for (Node ch : node.children) {
			display(ch);
		}

	}

	public int size2() {
		int v = size2(root);
		return v;
	}

	private int size2(Node node) {

		int count = 0;
		for (Node ch : node.children) {
			int p = size2(ch);
			count = count + p;
		}
		count = count + 1;
		return count;

	}

	public int max() {
		int v = max(root);
		return v;
	}

	private int max(Node node) {
		int max = node.data;

		for (Node ch : node.children) {
			int val = max(ch);
			if (val > max) {
				max = val;
			}
		}
		return max;

	}

	public int height() {
		int v = height(root);
		return v;
	}

	private int height(Node node) {
		int h = -1;
		for (Node ch : node.children) {
			int v = height(ch);
			if (v > h) {
				h = v;
			}
		}
		h = h + 1;
		return h;

	}

	public boolean find(int data) {
		boolean b = find(root, data);
		return b;
	}

	private boolean find(Node node, int data) {

		if (node.data == data) {
			return true;
		}
		for (Node ch : node.children) {
			boolean p = find(ch, data);
			if (p == true) {
				return true;
			}
		}
		return false;

	}

	public void preO() {
		preO(root);
	}

	private void preO(Node node) {
		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preO(child);
		}
	}

	public void postO() {
		postO(root);
	}

	public void postO(Node node) {
		for (Node child : node.children) {
			postO(child);
		}
		System.out.print(node.data + " ");
	}

	public void levelO() {

		LinkedList<Node> queue = new LinkedList<GenericTree.Node>();
		queue.addLast(root);

		while (queue.isEmpty() == false) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " ");

			for (Node child : node.children) {
				queue.addLast(child);
			}
		}
	}

	public void levelLinewise() {
		LinkedList<Node> cl = new LinkedList<GenericTree.Node>();
		LinkedList<Node> nl = new LinkedList<GenericTree.Node>();
		cl.add(root);

		while (nl.isEmpty() == false || cl.isEmpty() == false) {
			Node node = cl.removeFirst();
			System.out.print(node.data + " ");

			for (Node child : node.children) {
				nl.addLast(child);
			}

			if (cl.size() == 0) {
				System.out.println();
				cl = nl;
				nl = new LinkedList<GenericTree.Node>();
			}
		}
	}

	public void levelZZ() {
		LinkedList<Node> cl = new LinkedList<GenericTree.Node>();
		LinkedList<Node> nl = new LinkedList<GenericTree.Node>();
		cl.add(root);

		boolean flag = false;
		while (nl.isEmpty() == false || cl.isEmpty() == false) {
			Node node = cl.removeFirst();
			System.out.print(node.data + " ");
			if (flag == false) {
				for (Node child : node.children) {
					nl.addFirst(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					nl.addFirst(node.children.get(i));
				}
			}

			if (cl.size() == 0) {
				System.out.println();
				cl = nl;
				nl = new LinkedList<GenericTree.Node>();
				flag = !flag;
			}
		}
	}

	private class Heapmover {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int height = 0;
		boolean find = false;
		Node pred = null;
		Node succ = null;

		Node curr = null;
		Node prev = null;
		Node justLarger = null;
		// int jl = Integer.MAX_VALUE;
		int sl = Integer.MIN_VALUE;
	}

	public void multisolver() {
		Heapmover mover = new Heapmover();
		multisolver(90, 0, mover, root);
		if (mover.pred == null) {
			System.out.println("Pred : not found");
		} else {
			System.out.println("Pred : " + mover.pred.data);
		}
		if (mover.succ == null) {
			System.out.println("Succ : not found");
		} else {
			System.out.println("Succ : " + mover.succ.data);
		}
		System.out.println(mover.justLarger.data);
	}

	private void multisolver(int data, int depth, Heapmover mover, Node node) {
		mover.prev = mover.curr;
		mover.curr = node;

		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (depth > mover.height) {
			mover.height = depth;
		}
		if (node.data == data) {
			mover.find = true;
			mover.pred = mover.prev;
		} else if (mover.prev != null && mover.prev.data == data) {
			mover.succ = mover.curr;
		}
		// justlarger
		if (node.data > data) {
			if (mover.justLarger == null) {
				mover.justLarger = node;
			} else {
				if (mover.justLarger.data > node.data) {
					mover.justLarger = node;
				}
			}
		}

		for (Node child : node.children) {
			multisolver(data, depth + 1, mover, child);
		}
	}

	public int kthSmallest(int k) {
		int rv = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			Heapmover mover = new Heapmover();
			multisolver(rv, 0, mover, root);
			rv = mover.justLarger.data;
		}
		return rv;
	}

	public boolean AreIdenticallyShaped(GenericTree other) {
		return AreIdenticallyShaped(this.root, other.root);
	}

	private boolean AreIdenticallyShaped(Node tnode, Node onode) {

		if (tnode.children.size() != onode.children.size()) {
			return false;
		}
		for (int i = 0; i < tnode.children.size(); i++) {
			boolean b = AreIdenticallyShaped(tnode.children.get(i), onode.children.get(i));

			if (b == false) {
				return false;
			}
		}
		return true;
	}

	public boolean AreMirrorImaged(GenericTree other) {
		return AreMirrorImaged(this.root, other.root);
	}

	private boolean AreMirrorImaged(Node tnode, Node onode) {

		if (tnode.children.size() != onode.children.size()) {
			return false;
		}
		for (int i = 0; i < tnode.children.size(); i++) {
			boolean b = AreIdenticallyShaped(tnode.children.get(i), onode.children.get(onode.children.size() - 1 - i));

			if (b == false) {
				return false;
			}
		}
		return true;
	}

//	public boolean isMirrorItself() {
//		return isMirrorItself(this.root.children.get(0),this.root.children.get(0));
//	}

//	private boolean isMirrorItself(Node lnode, Node rnode) {
//		
//		if (rnode.children.size() != lnode.children.size()) {
//			return false;
//		}

//		for (int l = 0, r = rnode.children.size()-1; l < rnode.children.size() / 2; l++, r--) {
//			Node lnode = node.children.get(l);
//			Node rnode = node.children.get(r);
//			boolean b = isMirrorItself(lnode.children.get(l), rnode.children.get(r));
//
//			if (b == false) {
//				return false;
//			}
//		}
//		return true;
//	}
}
