package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import BinaryTrees.BinaryTree.Node;

public class BinaryTree {
	public class Node {
		int data;
		Node left = null;
		Node right = null;
	}

	private Node root;
	private int size;

	// public BinaryTree() {
	// this.root = takeInput(new Scanner(System.in), null, false);
	// }

	private Node takeInput(Scanner sc, Node parent, boolean ilc) { // isleftchild
		// prompt
		if (parent == null) {
			System.out.print("Enter the data for the root : ");
		} else if (ilc == true) {
			System.out.print("Enter the data for left child of : " + parent.data);
		} else {
			System.out.print("Enter the data for right child of : " + parent.data);
		}

		// making node and setting value
		Node child = new Node();
		child.data = sc.nextInt();
		size++;

		// System.out.print("Does " + child.data + "have a left child? ");
		boolean haslc = sc.nextBoolean();
		if (haslc == true) {
			child.left = takeInput(sc, child, true); // child?
		} else {
			child.left = null;
		}

		// System.out.print("Does " + child.data + "have a right child? ");
		boolean hasrc = sc.nextBoolean();
		if (hasrc == true) {
			child.right = takeInput(sc, child, false); // child?
		} else {
			child.right = null;
		}

		return child;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += " .=> ";
		} else {
			str += node.left.data + " => ";
		}
		str += node.data;
		if (node.right == null) {
			str += " <=. ";
		} else {
			str += " <= " + node.right.data;
		}

		System.out.println();
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node child) {
		if (child == null) {
			return 0;
		}
		return size2(child.left) + 1 + size2(child.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node child) {
		int val = Integer.MIN_VALUE;
		if (child == null) {
			return Integer.MIN_VALUE;
		} else {
			if (child.data > val) {
				val = child.data;
			}
			val = Math.max(max(child.left), Math.max(max(child.right), val));
		}
		return val;
	}

	public int min() {
		return min(root);
	}

	private int min(Node child) {
		int val = Integer.MAX_VALUE;
		if (child == null) {
			return Integer.MAX_VALUE;
		} else {
			if (child.data < val) {
				val = child.data;
			}
			val = Math.min(min(child.left), Math.min(min(child.right), val));
		}
		return val;
	}

	public boolean find(int val) {
		return find(root, val);
	}

	private boolean find(Node child, int val) {
		if (child == null) {
			return false;
		}
		if (child.data == val) {
			return true;
		}
		return find(child.left, val) || find(child.right, val);
	}

	public int height() {
		return height(root);
	}

	private int height(Node child) {
		if (child == null) {
			return -1;
		}
		int lheight = height(child.left);
		int rheight = height(child.right);
		return Math.max(lheight, rheight) + 1;
	}

	// public void printkfar(int val, int k){
	// System.out.println(printkfar(val, k, root));
	// }

	// private void printkfar(int val, int k, Node child){
	// if(child==null){
	// return;
	// }
	// if(child.data==val){
	// for(int i=0; i<k; i++){
	// int n = printkfar(val,k,child.left);
	// }
	// }
	// return 1;
	// }

	public void preO() {
		preO(root);
		System.out.println();
	}

	private void preO(Node child) {
		if (child == null) {
			return;
		}
		System.out.print(child.data + " ");
		preO(child.left);
		preO(child.right);
	}

	public void postO() {
		postO(root);
		System.out.println();
	}

	private void postO(Node child) {
		if (child == null) {
			return;
		}
		postO(child.left);
		postO(child.right);
		System.out.print(child.data + " ");
	}

	public void inO() {
		inO(root);
		System.out.println();
	}

	private void inO(Node child) {
		if (child == null) {
			return;
		}
		inO(child.left);
		System.out.print(child.data + " ");
		inO(child.right);
	}

	private class Pair {
		Node node;
		boolean isSelfDone;
		boolean hcLeft;
		boolean hcRight;
	}

	public void preOI() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();

		Pair rootp = new Pair();
		rootp.node = root;
		stack.addFirst(rootp);

		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();

			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.isSelfDone == false) {
				tosp.isSelfDone = true;
				System.out.print(tosp.node.data + " ");
			} else if (tosp.hcLeft == false) {
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

				tosp.hcLeft = true;
			} else if (tosp.hcRight == false) {
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);

				tosp.hcRight = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postOI() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();

		Pair rootp = new Pair();
		rootp.node = root;
		stack.addFirst(rootp);

		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();

			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.hcLeft == false) {
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

				tosp.hcLeft = true;
			} else if (tosp.isSelfDone == false) {
				tosp.isSelfDone = true;
				System.out.print(tosp.node.data + " ");
			} else if (tosp.hcRight == false) {
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);

				tosp.hcRight = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	public void inOI() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();

		Pair rootp = new Pair();
		rootp.node = root;
		stack.addFirst(rootp);

		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();

			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.hcLeft == false) {
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

				tosp.hcLeft = true;
			} else if (tosp.hcRight == false) {
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);

				tosp.hcRight = true;
			} else if (tosp.isSelfDone == false) {
				tosp.isSelfDone = true;
				System.out.print(tosp.node.data + " ");
			} else {
				stack.removeFirst();
			}
		}
	}

	private class levelPair {
		Node node;
		int level = 0;
	}

	public void levelO() {
		LinkedList<levelPair> queue = new LinkedList<BinaryTree.levelPair>();

		levelPair rootp = new levelPair();
		rootp.node = root;
		rootp.level = 0;
		queue.addLast(rootp);

		while (queue.size() > 0) {
			levelPair toqp = queue.removeFirst();

			System.out.print(toqp.node.data + " ");

			if (toqp.node.left != null) {
				levelPair lp = new levelPair();
				lp.node = toqp.node.left;
				lp.level = toqp.level + 1;
				queue.addLast(lp);
			}
			if (toqp.node.right != null) {
				levelPair rp = new levelPair();
				rp.node = toqp.node.right;
				rp.level = toqp.level + 1;
				queue.addLast(rp);
			}
		}
	}

	public int diameter() {
		return this.diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int lheight = height(node.left);
		int rheight = height(node.right);

		int f1 = lheight + rheight + 2; // height of node

		int f2 = diameter(node.left); // diameter of the left side of the tree

		int f3 = diameter(node.right); // diameter of the right side of the tree

		return Math.max(f1, Math.max(f2, f3));
	}

	private static class Diapair {
		int height;
		int diameter;
	}

	public int diameter2() {
		return this.diameter2(root).diameter;
	}

	private Diapair diameter2(Node node) {
		// base case
		if (node == null) {
			Diapair dp = new Diapair();
			dp.height = -1;
			dp.diameter = 0;
			return dp;
		}

		Diapair lp = diameter2(node.left);
		Diapair rp = diameter2(node.right);

		Diapair mp = new Diapair();

		// setting the height the pair
		mp.height = Math.max(lp.height, rp.height) + 1;

		int f1 = lp.height + rp.height + 2;
		int f2 = lp.diameter;
		int f3 = rp.diameter;
		// setting the diameter of the pair
		mp.diameter = Math.max(f1, Math.max(f2, f3));

		return mp;
	}

	public boolean IsBalanced() {
		return IsBalanced(root);
	}

	private boolean IsBalanced(Node node) {
		if (node == null) {
			return true;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		int lheight = height(node.left);
		int rheight = height(node.right);
		if (Math.abs(lheight - rheight) > 1) {
			return false;
		}
		boolean b1 = IsBalanced(node.left);
		boolean b2 = IsBalanced(node.right);
		return b1 && b2;
	}

	private static class Balpair {
		int height;
		boolean balance;
	}

	public boolean IsBalanced2() {
		return IsBalanced2(root).balance;
	}

	private Balpair IsBalanced2(Node node) {
		if (node == null) {
			Balpair bp = new Balpair();
			bp.height = -1;
			bp.balance = true;
			return bp;
		}
		Balpair lp = IsBalanced2(node.left);
		Balpair rp = IsBalanced2(node.right);

		Balpair mp = new Balpair();

		mp.height = Math.max(lp.height, rp.height) + 1;

		mp.balance = lp.balance && rp.balance && Math.abs(lp.height - rp.height) <= 1;

		return mp;
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node node) {
		if (node == null) {
			return true;
		}
		boolean b1 = isBST(node.left);
		boolean b2 = isBST(node.right);

		int max1 = max(node.left);
		int min2 = min(node.right);

		return b1 && b2 && max1 < node.data && min2 > node.data;
	}

	private static class isBSTpair {
		boolean isSelfBST;
		int leftmax;
		int rightmin;
		Node largestBSTRoot;
		int largestBSTSize;
	}

	public int isBST2() {
		return isBST2(root).largestBSTSize;
	}

	// public boolean isBST2(){
	// return isBST2(root).isSelfBST;
	// }

	private isBSTpair isBST2(Node node) {
		if (node == null) {
			isBSTpair bp = new isBSTpair();
			bp.isSelfBST = true;
			bp.leftmax = Integer.MIN_VALUE;
			bp.rightmin = Integer.MAX_VALUE;
			bp.largestBSTRoot = null;
			bp.largestBSTSize = 0;
			return bp;
		}
		isBSTpair lp = isBST2(node.left);
		isBSTpair rp = isBST2(node.right);

		isBSTpair mp = new isBSTpair();

		mp.leftmax = Math.max(node.data, Math.max(lp.leftmax, rp.leftmax));
		mp.rightmin = Math.min(node.data, Math.min(lp.rightmin, rp.rightmin));
		mp.isSelfBST = lp.isSelfBST && rp.isSelfBST && node.data > lp.leftmax && node.data < rp.rightmin;

		if (mp.isSelfBST == true) {
			mp.largestBSTRoot = node;
			mp.largestBSTSize = lp.largestBSTSize + rp.largestBSTSize + 1;
		} else {
			if (lp.largestBSTSize > rp.largestBSTSize) {
				mp.largestBSTRoot = lp.largestBSTRoot;
				mp.largestBSTSize = lp.largestBSTSize;
			} else {
				mp.largestBSTRoot = rp.largestBSTRoot;
				mp.largestBSTSize = rp.largestBSTSize;
			}
		}

		return mp;
	}

	 public BinaryTree(int[] pre, int[] in){
	 this.root = this.construct(pre,in,0,pre.length-1,0,in.length-1);
	 }
	
	 public Node construct(int[] pre, int[] in, int psi, int pei,int isi, int
	 iei){
	 if(psi>pei || isi>iei){
	 return null;
	 }
	
	 Node node = new Node();
	 node.data = pre[psi];
	 int searchIdx = searchByIn(in,isi,iei,node.data);
	 int numLSE = searchIdx - isi;
	 node.left = construct(pre,in,psi+1,psi+numLSE,isi,searchIdx-1);
	 node.right = construct(pre,in,psi+numLSE+1, pei, searchIdx+1, iei);
	
	 return node;
	 }
	
	 public int searchByIn(int[] in, int isi, int iei, int data){
	 for(int i=isi; i<=iei; i++){
	 if(in[i]==data){
	 return i;
	 }
	 }
	 return -1;
	 }

//	public BinaryTree(int[] post, int[] in) {
//		this.root = this.construct(post, in, 0, post.length - 1, 0, in.length - 1);
//	}
//
//	public Node construct(int[] post, int[] in, int psi, int pei, int isi, int iei) {
//		if (psi > pei || isi > iei) {
//			return null;
//		}
//
//		Node node = new Node();
//		node.data = post[pei];
//		int searchIdx = searchByIn(in, isi, iei, node.data);
//		int numRSE = iei - searchIdx;
//		node.right = construct(post, in, pei - numRSE, pei - 1, searchIdx + 1, iei);
//		node.left = construct(post, in, psi, pei - numRSE - 1, isi, searchIdx - 1);
//
//		return node;
//	}
//
//	public int searchByIn(int[] in, int isi, int iei, int data) {
//		for (int i = isi; i <= iei; i++) {
//			if (in[i] == data) {
//				return i;
//			}
//		}
//		return -1;
//	}

	public void removeLeaves() {
		this.removeLeaves(null, root, false);
	}

	private void removeLeaves(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		}
		if (child.left == null && child.right == null && ilc == true) {
			parent.left = null;
		}
		if (child.left == null && child.right == null && ilc == false) {
			parent.right = null;
		}
		removeLeaves(child, child.left, true);
		removeLeaves(child, child.right, false);
	}

	public void printSiblingLess() {
		this.printSiblingLess(null, this.root, false);
	}

	private void printSiblingLess(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		} 
		if(parent!=null){
			System.out.print(child.data+" ");
		}
		if (parent.left == null && ilc==false) {
			System.out.print(child.data+" ");
		}
		else if (parent.right == null && ilc==true) {
			System.out.print(child.data+" ");
		}
		printSiblingLess(child, child.left, true);
		printSiblingLess(child, child.right, false);
	}
	
	public ArrayList<Integer> pathFromRoot(int data){
		return this.pathFromRoot(data,this.root);
	}
	private ArrayList<Integer> pathFromRoot(int data, Node node){
		if(node==null){
			return new ArrayList<Integer>();
		}
		
		if(node.data==data){
			ArrayList<Integer> bresult = new ArrayList<>();
			bresult.add(node.data);
			return bresult;
		}
		
		ArrayList<Integer> arrL = pathFromRoot(data,node.left);
		if(arrL.size()>0){
			arrL.add(node.data);
			return arrL;
		}
		
		ArrayList<Integer> arrR = pathFromRoot(data,node.right);
		if(arrR.size()>0){
			arrR.add(node.data);
			return arrR;
		} 
		return new ArrayList<Integer>();
	}
	
	public void rootToLeafPathWithTarget(int target){
		this.rootToLeafPathWithTarget(target, this.root, 0, "");  //sumsofar
	}
	
	public void rootToLeafPathWithTarget(int target, Node node, int ssf, String psf){
		if(node == null){
			return;
		}
		if(node.left == null && node.right==null){
			if(ssf+node.data==target){
				System.out.print(psf+" "+ node.data);
			}
		}
		
		rootToLeafPathWithTarget(target,node.left,ssf+node.data,psf+" "+node.data);
		rootToLeafPathWithTarget(target,node.right,ssf+node.data,psf+" "+node.data);
	}
	
	public void printkDown(int k){
		this.printkDown(root,k);
	}
	
	public void printkDown(Node node, int k){
		if(node==null || k<0){
			return;
		}
		if(k==0){
			System.out.print(node.data+" ");
			return;
		}
		printkDown(node.left, k-1);
		printkDown(node.right, k-1);
	}
	
	public void printkFar(int k, int data){
		this.printkFar(root,k, data);
	}
	private void printkFar(Node node, int k, int data){
		
		ArrayList<Node> list = this.pathFromRootNode(data,root);
		ArrayList<Boolean> directions = new ArrayList<Boolean>();
		directions.add(null);
		
		for(int i=1; i<list.size() ; i++){
			Node parent = list.get(i);
			Node child = list.get(i-1);
			directions.add(parent.left==child);
		}
		
		for(int i=0; i<list.size(); i++){
			Node temp = list.get(i);
			
			if(i==0){
				printkDown(temp,k);
			} else if(i==k){
				System.out.print(temp.data+" ");
			} else {
				if(directions.get(i)==true){
					printkDown(temp.right,k-1-i);
				} else {
					printkDown(temp.left,k-1-i);
				}
			}
		}
	}
	private ArrayList<Node> pathFromRootNode(int data, Node node){
		if(node==null){
			return new ArrayList<Node>();
		}
		
		if(node.data==data){
			ArrayList<Node> bresult = new ArrayList<>();
			bresult.add(node);
			return bresult;
		}
		
		ArrayList<Node> arrL = pathFromRootNode(data,node.left);
		if(arrL.size()>0){
			arrL.add(node);
			return arrL;
		}
		
		ArrayList<Node> arrR = pathFromRootNode(data,node.right);
		if(arrR.size()>0){
			arrR.add(node);
			return arrR;
		} 
		return new ArrayList<Node>();
	}
}