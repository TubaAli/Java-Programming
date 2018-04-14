package lecture_20;

public class lps {

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int s = isSquare(mat);
		System.out.println(s);
	}

	private static int isSquare(int[][] mat) {
		int[][] board = new int[mat.length + 1][mat[0].length + 1];
		for (int i = mat.length - 1; i >= 0; i--) {
			for (int j = mat[0].length - 1; j >= 0; j--) {
				if (mat[i][j] != 0) {
					board[i][j] = Math.min(board[i + 1][j + 1], Math.min(board[i + 1][j], board[i][j + 1])) + 1;
				} else {
					board[i][j] = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > max) {
					max = board[i][j];
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == max) {
					System.out.println(i+" "+j);
				}
			}
		}
		return max;
	}
}
