package lecture_16;

import java.util.ArrayList;

public class recureToIterNode {

	public static void main(String[] args) {
		printSSRtoI("abc");
	}

	public static void printSSRtoI(String str) {
		Node root = new Node("abc", "");
		ArrayList<Node> stack = new ArrayList<Node>();
		stack.add(root);

		while (stack.size() > 0) {
			Node nAtTop = stack.get(stack.size() - 1);
			if (nAtTop.isLeftDone == false) {
				nAtTop.isLeftDone = true;
				if (nAtTop.ques.length() > 0) {
					Node left = new Node(nAtTop.ques.substring(1), nAtTop.ans);
					stack.add(left);
				}
			} else if (nAtTop.isSelfDone == false) {
				nAtTop.isSelfDone = true;
				if (nAtTop.ques.length() == 0) {
					System.out.println(nAtTop.ans);
				}
			} else if (nAtTop.isRightDone == false) {
				nAtTop.isRightDone = true;
				if (nAtTop.ques.length() > 0) {
					Node right = new Node(nAtTop.ques.substring(1), nAtTop.ans + nAtTop.ques.charAt(0));
					stack.add(right);
				}
			} else {
				stack.remove(stack.size() - 1);
			}
		}
	}

	private static class Node {
		String ques;
		String ans;

		boolean isLeftDone = false;
		boolean isSelfDone = false;
		boolean isRightDone = false;

		public Node(String ques, String ans) {
			this.ques = ques;
			this.ans = ans;
		}
	}
}
