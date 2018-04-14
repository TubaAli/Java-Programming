package lecture_16;

import java.util.ArrayList;

public class recurToIterMazePath {

	public static void main(String[] args) {
		printMPRtoIter(7, 10);
	}

	public static void printMPRtoIter(int curr, int end) {
		Node root = new Node(curr, end, "");
		ArrayList<Node> stack = new ArrayList<Node>();
		stack.add(root);

		while (stack.size() > 0) {
			Node nAtTop = stack.get(stack.size() - 1);

			if (nAtTop.diceValsDone < nAtTop.tDiceVals) {
				nAtTop.diceValsDone++;
				if (nAtTop.curr + nAtTop.diceValsDone <= nAtTop.end) {
					Node child = new Node(nAtTop.curr + nAtTop.diceValsDone, nAtTop.end,
							nAtTop.psf + nAtTop.diceValsDone);
					stack.add(child);
				}
			} else if (nAtTop.isSelfDone == false) {
				nAtTop.isSelfDone = true;
				if (nAtTop.curr == nAtTop.end) {
					System.out.println(nAtTop.psf);
				}

			} else {
				stack.remove(stack.size() - 1);
			}
		}
	}

	public static class Node {
		int diceValsDone = 0;
		int tDiceVals = 6;
		boolean isSelfDone;

		int curr = 0;
		int end;
		String psf = "";

		public Node(int curr, int end, String psf) {
			this.curr = curr;
			this.end = end;
			this.psf = psf;
		}
	}
}
