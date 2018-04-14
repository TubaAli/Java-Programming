package BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import BinaryTrees.BinaryTree.Node;

public class Client{

	public static void main(String[] args) {
		// 50 true 25 true 12 false false true 37 false false true 75 true 62
		// false false true 87 false false
//		BinaryTree t = new BinaryTree();
//		t.display();
		//
		// System.out.println(t.size2());
		//
		// System.out.println(t.max());
		//
		// System.out.println(t.find(25));
		//
		// System.out.println(t.height());
		//
		// t.preO();
		// t.preOI();
		// System.out.println();
		//
		// t.postO();
		// t.postOI();
		// System.out.println();
		//
		// t.inO();
		// t.inOI();
		// System.out.println();
		//
		// t.levelO();
		//
		// binaries();

		// System.out.println(t.diameter());
		// System.out.println(t.diameter2());

		// System.out.println(t.IsBalanced());
		//
		// System.out.println(t.isBST());

		// making a tree from preorder and inorder by using constructor as we're
		// making a whole tree
//		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
//		int[] in = { 12, 25, 37, 50, 62, 75, 87 };
//		int[] post = { 12, 37, 25, 62, 87, 75, 50};
		
		int[] pre = {10,20,40,50,80,120,140,150,90,100,230,240,110,160,180,190,200,210,170,30,60,70};
		int[] in = {40,20,140,120,150,80,50,230,100,240,90,180,160,200,190,210,110,170,10,60,30,70};
		
		BinaryTree t = new BinaryTree(pre,in);
		t.printkFar(3, 110);
//		t.display();
//		System.out.println(t.pathFromRoot(62));
		
//		ArrayList<Integer> arr = t.pathFromRoot(62);
//		Collections.reverse(arr);
//		System.out.println(arr);
		
//		t.removeLeaves();
//		t.printSiblingLess();
		
//		t.display();
//		t.rootToLeafPathWithTarget(187);
//		System.out.println(t.isBST2());
	}

	private static class LevelPair {
		int count = 0;
		String binary = "";
	}

	static int counter = 0;

	private static void binaries() {
		LinkedList<LevelPair> queue = new LinkedList<LevelPair>();

		LevelPair rootp = new LevelPair();
		rootp.binary = "1";
		rootp.count = 1;
		queue.addLast(rootp);

		while (true) {
			LevelPair removeP = queue.removeFirst();

			System.out.print(removeP.binary + " ");
			counter++;
			if (counter >= 15) {
				break;
			}
			LevelPair leftp = new LevelPair();
			leftp.count = 2 * removeP.count;
			leftp.binary = removeP.binary + "0";
			queue.addLast(leftp);

			LevelPair rightp = new LevelPair();
			rightp.count = 2 * removeP.count + 1;
			rightp.binary += removeP.binary + "1";
			queue.addLast(rightp);
		}
	}

}
