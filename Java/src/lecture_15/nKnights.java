package lecture_15;

public class nKnights {

	public static void main(String[] args) {
		boolean[][] board = new boolean[3][3];
		printNKnights(board, 0, 0, "");
		System.out.println(counter);
		// 0 -> boxNum 0-> knight placed so far
	}
static int counter = 0; 
	private static void printNKnights(boolean[][] board, int boxNum, int kpsf, String csf) {
		if (kpsf == board.length) {
			System.out.println(csf + ".");
			counter++;
			return;
		}
		for (int box = boxNum; box < board.length * board.length; box++) {
			int row = box / board.length;
			int col = box % board[0].length;
			if (isKnightValid(board,row,col) == true) {
				board[row][col] = true;
				printNKnights(board, box + 1, kpsf + 1, csf + "[" + row + "," + col + "]" + "-");
				board[row][col] = false;
			}
		}
	}

	private static boolean isKnightValid(boolean[][] board, int row, int col) {
			int rm1 = row - 1;
			int rp1 = row + 1;
			int cm1 = col - 1;
			int cp1 = col + 1;
			int rm2 = row - 2;
			int rp2 = row + 2;
			int cm2 = col - 2;
			int cp2 = col + 2;
			if (rm2 >= 0 && cp1 < board.length && board[rm2][cp1] == true) {
				return false;
			}
			if (rm1 >= 0 && cp2 < board.length && board[rm1][cp2] == true) {
				return false;
			}
			if (rp1 < board.length && cp2 < board.length && board[rp1][cp2] == true) {
				return false;
			}
			if (rp2 < board.length && cp1 < board.length && board[rp2][cp1] == true) {
				return false;
			}
			if (rp2 < board.length && cm1 >= 0 && board[rp2][cm1] == true) {
				return false;
			}
			if (rp1 < board.length && cm2 >= 0 && board[rp1][cm2] == true) {
				return false;
			}
			if (rm1 >=0 && cm2 >= 0 && board[rm1][cm2] == true) {
				return false;
			}
			if (rm2 >=0 && cm1 >=0 && board[rm2][cm1] == true) {
				return false;
			}
		return true;
	}
}